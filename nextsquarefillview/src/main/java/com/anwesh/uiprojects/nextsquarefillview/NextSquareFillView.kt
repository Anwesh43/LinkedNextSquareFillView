package com.anwesh.uiprojects.nextsquarefillview

/**
 * Created by anweshmishra on 14/09/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Color
import android.graphics.RectF
import android.graphics.Canvas

val colors : Array<Int> = arrayOf(
        "#F44336",
        "#2196F3",
        "#FFC107",
        "#3F51B5",
        "#4CAF50"
).map({Color.parseColor(it)}).toTypedArray()
val strokeFactor : Float = 90f
val parts : Int = 5
val scGap : Float = 0.02f / parts
val delay : Long = 20
val backColor : Int = Color.parseColor("#BDBDBD")