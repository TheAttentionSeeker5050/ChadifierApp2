package com.example.chadifierapp2.utils

import java.text.SimpleDateFormat
import java.util.Date

interface FormattingTools {


//    a method for formatting date
    fun myFormatDateTime(inputDate: Date): String {
        val simpleDateFormat : SimpleDateFormat = SimpleDateFormat("MM/dd/yyyy HH:mm")
        return simpleDateFormat.format(inputDate)

    }

    fun myFormatDate(inputDate: Date): String {
        val simpleDateFormat : SimpleDateFormat = SimpleDateFormat("MM/dd/yyyy")

        return simpleDateFormat.format(inputDate)
    }

//    make this interface be used by any other class
    companion object : FormattingTools


}