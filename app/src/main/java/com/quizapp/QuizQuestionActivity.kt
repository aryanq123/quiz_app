package com.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionActivity:AppCompatActivity(),View.OnClickListener {
    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Questions>?=null
    private var mSelectedOptionPosition:Int=0
    private var isSelectedAnswer:Boolean=false
    private var mUsserName:String?=null
    private var mCoorectAnswer:Int=0
    private var progressBar:ProgressBar?=null
    private var tvProgressBar:TextView?=null
    private var tvProgress:TextView?=null
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null
    private var tvOptionOne:TextView?=null
    private var tvOptionTwo:TextView?=null
    private var tvOptionThree:TextView?=null
    private var tvOptionFour:TextView?=null
    private var btnSubmit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_questions)
        setPassingRetriveDataIntent()
        setUpView()
        getQuestions()
        setQuestionList()
        defaultOptionView()

    }
    fun setUpView(){
        progressBar=findViewById(R.id.progressbar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_question)
        tvOptionOne=findViewById(R.id.tv_option_one)
        tvOptionTwo=findViewById(R.id.tv_option_two)
        tvOptionThree=findViewById(R.id.tv_option_three)
        tvOptionFour=findViewById(R.id.tv_option_four)
        btnSubmit=findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
    }
    fun setPassingRetriveDataIntent(){
        mUsserName=intent.getStringExtra(Constants.User_Name)
    }
    fun getQuestions(){
        mQuestionList=Constants.getQuestions()
    }
    fun setQuestionList(){
        defaultOptionView()
        mQuestionList?.let {
            val questionList=it
            var currentPostion=mCurrentPosition
            val question:Questions=questionList[currentPostion-1]
            ivImage?.setImageResource(question.image)
            progressBar?.progress=currentPostion
            tvProgress?.text="$currentPostion/${questionList.size}"
            tvQuestion?.text=question.question
            tvOptionOne?.text=question.optionOne
            tvOptionTwo?.text=question.optionTwo
            tvOptionThree?.text=question.optionThere
            tvOptionFour?.text=question.optionFour
            if(currentPostion>questionList.size){
                btnSubmit?.text="FINISH"
            }else{
                btnSubmit?.text="SUBMIT"
            }


        }
    }
    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0,it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)

        }
        tvOptionFour?.let {
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface=Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
        }
    }
    private fun selectOptionView(tv:TextView,SelectOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition=SelectOptionNum
        isSelectedAnswer=true
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
    }

    override fun onClick(v: View?) {
        val isAnswerNotSubmitDone:Boolean=(btnSubmit?.text)=="SUBMIT"
        when(v?.id){
            R.id.tv_option_one->{
                if(isAnswerNotSubmitDone){
                    tvOptionOne?.let {
                        selectOptionView(it,1)
                    }
                }
            }
            R.id.tv_option_two->{
                if(isAnswerNotSubmitDone){
                    tvOptionTwo?.let {
                        selectOptionView(it,2)
                    }
                }
            }
            R.id.tv_option_three->{
                if(isAnswerNotSubmitDone){
                    tvOptionThree?.let {
                        selectOptionView(it,3)
                    }
                }
            }
            R.id.tv_option_four->{
                if(isAnswerNotSubmitDone){
                    tvOptionFour?.let {
                        selectOptionView(it,4)
                    }
                }
            }
            R.id.btn_submit->{
                btnSubmit?.let {
                    if (mSelectedOptionPosition==0){
                        if(isSelectedAnswer==true){
                            isSelectedAnswer==false
                            mCurrentPosition++
                            when{
                                mCurrentPosition<=mQuestionList!!.size->{
                                    setQuestionList()
                                }
                                else->{
                                    val intent=Intent(this,ResultActivity::class.java)
                                    intent.putExtra(Constants.User_Name,mUsserName)
                                    intent.putExtra(Constants.Correct_Answer,mCoorectAnswer)
                                    intent.putExtra(Constants.Total_Questions,mQuestionList)
                                    startActivity(intent)
                                    finish()
                                }
                            }

                        }else{
                            Toast.makeText(this,"Please select Answer", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else{
                        val question=mQuestionList?.get(mCurrentPosition-1)
                        question?.let {
                            if (it.Correctanswer!=mCurrentPosition){
                                answerview(mSelectedOptionPosition,
                                    R.drawable.correct_option_border_bg
                                )

                            }else{
                                mCoorectAnswer++
                            }
                            answerview(it.Correctanswer,R.drawable.ic_launcher_foreground)
                            if (mCurrentPosition==mQuestionList!!.size){
                                btnSubmit?.text="FINISH"
                            }else{
                                btnSubmit?.text="Got to next question"
                            }
                            mSelectedOptionPosition=0
                        }
                    }
                }

            }
        }

    }
    private fun answerview(answer:Int,drawbleview:Int){
        when(answer){
            1->{
                tvOptionOne?.background=ContextCompat.getDrawable(this,drawbleview)
            }
            2->{
                tvOptionTwo?.background=ContextCompat.getDrawable(this,drawbleview)
            }
            3->{
                tvOptionThree?.background=ContextCompat.getDrawable(this,drawbleview)
            }
            4->{
                tvOptionFour?.background=ContextCompat.getDrawable(this,drawbleview)
            }
        }

    }

}