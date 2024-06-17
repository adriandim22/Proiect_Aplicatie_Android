package com.cst.proiectaplicatieandroid.utils.extensions

import android.util.Log

fun String.logErrorMessage(tag: String = "AppTag") {
    Log.e(tag, this)
}

fun doSomething() {
    val myString = "blabla"
    myString.logErrorMessage()

    "blabla".logErrorMessage("tag")
}


