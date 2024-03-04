package com.quizapp

object Constants {
    const val User_Name: String = "user_name"
    const val Total_Questions: String = "total_questions"
    const val Correct_Answer: String = "correct_answers"

    fun getQuestions(): ArrayList<Questions> {
        val questionList = ArrayList<Questions>()
        val que1 = Questions(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )
        questionList.add(que1)
        val que2 = Questions(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Australia",
            "Austria", "Maldova", 2
        )
        questionList.add(que2)
        val que3 = Questions(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentin", "India",
            "Nepal", "Brazil", 4
        )
        questionList.add(que3)
        val que4 = Questions(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )
        questionList.add(que4)
        val que5 = Questions(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )
        questionList.add(que5)
        val que6 = Questions(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )
        questionList.add(que6)
        val que7 = Questions(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )
        questionList.add(que7)
        val que8 = Questions(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )
        questionList.add(que8)
        val que9 = Questions(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New zealand",
            "Tuvalu", "USA", 2
        )
        questionList.add(que9)
        val que10 = Questions(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )
        questionList.add(que10)

        return questionList
    }

    var Max_Progress_Value = 10


}