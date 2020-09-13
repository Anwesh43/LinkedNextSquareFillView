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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawNextSquareFill(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val wGap : Float = w / parts
    val hGap : Float = h / parts
    drawRect(RectF(0f, 0f, wGap * sf1, hGap * sf1), paint)
    for (j in 1..(parts - 1)) {
        val sfj : Float = sf.divideScale(j, parts)
        val currW : Float = wGap * sfj
        val currH : Float = hGap * sfj
        save()
        translate(wGap * j, hGap * j)
        drawRect(RectF(-wGap + currW, -hGap + currH, 0f, 0f), paint)
        drawRect(RectF(0f, 0f, currW, currH), paint)
        restore()
    }
}

fun Canvas.drawNSFNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    drawNextSquareFill(scale, w, h, paint)
}

class NextSquareFillView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}