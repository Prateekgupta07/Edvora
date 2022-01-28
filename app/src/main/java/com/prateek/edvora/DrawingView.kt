package com.prateek.edvora

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.prateek.edvora.MainActivity.Companion.paint1
import com.prateek.edvora.MainActivity.Companion.type1
import com.prateek.edvora.MainActivity.Companion.path
import java.nio.file.Path

class DrawingView : View{
    var params : ViewGroup.LayoutParams?=null

    companion object{
        var pathlist= ArrayList<android.graphics.Path>()
        var colorList = ArrayList<Int>()
        var current = Color.BLACK
    }

    constructor(context: Context) : this(context, null){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){

        init()
    }
    private fun init(){
        paint1.isAntiAlias=true
        paint1.color= current
        paint1.style=Paint.Style.STROKE
        paint1.strokeJoin=Paint.Join.ROUND
        paint1.strokeWidth=8f

        params= ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        var x = event.x
        var y = event.y


    when (event?.action) {
        MotionEvent.ACTION_DOWN -> {
            path.moveTo(x, y)
            return true
        }
        MotionEvent.ACTION_MOVE -> {
            path.lineTo(x, y)
            pathlist.add(path)
            colorList.add(current)
        }

        else -> return false
    }

        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas) {
        for (i in pathlist.indices){
            paint1.setColor(colorList[i])
            if(type1=="pencil") {
                canvas.drawPath(pathlist[i], paint1)
            }
            else if (type1=="circle") {
                var x= getX()
                var y= getY()

                canvas.drawCircle(x/2,y/2, 50F, paint1)
            }
            invalidate()
        }
    }



}




//    (context: Context,attr:AttributeSet):View(context,attr) {
//    private var mDrawPath:CustomPath?=null
//    private var mCanvasBitmap:Bitmap?=null
//    private var mPaint: Paint?=null
//    private var mCanvasPaint:Paint?=null
//    private var mCanva:Canvas?=null
//    private  var mBrushSize:Float=0.toFloat()
//    private  var color:Int=Color.BLACK
//    private val mPaths=ArrayList<CustomPath>()
//    private val undoPath=ArrayList<CustomPath>()
//
//    init{
//        setUpDrawing()
//    }
//
//    private fun setUpDrawing() {
//        mPaint=Paint()
//        mDrawPath=CustomPath(color,mBrushSize)
//        mPaint!!.color=color
//        mPaint!!.style=Paint.Style.STROKE
//        mPaint!!.strokeJoin=Paint.Join.ROUND
//        mPaint!!.strokeCap=Paint.Cap.ROUND
//        mCanvasPaint= Paint(Paint.DITHER_FLAG)
//    }
//
//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        super.onSizeChanged(w, h, oldw, oldh)
//        mCanvasBitmap= Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
//        mCanva=Canvas(mCanvasBitmap!!)
//    }
//
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        canvas!!.drawBitmap(mCanvasBitmap!!,0f,0f,mCanvasPaint)
//        for(path in mPaths){
//            mPaint!!.strokeWidth=path.BrushSize
//            mPaint!!.color =path.color
//
//            canvas.drawPath(path,mPaint!!)
//        }
//        if(! mDrawPath!!.isEmpty){
//            mPaint!!.strokeWidth=mDrawPath!!.BrushSize
//            mPaint!!.color =mDrawPath!!.color
//
//            canvas.drawPath(mDrawPath!!,mPaint!!)
//        }
//
//    }
//    fun setColor(newColor:String){
//        color=Color.parseColor(newColor)
//        mPaint!!.color=color
//    }
//    fun undoPath(){
//        if(mPaths.size>0){
//            undoPath.add(mPaths.removeAt(mPaths.size-1))
//            invalidate()
//        }
//
//
//    }
//
//
//
//    fun setUpBrushSize(newSize:Float){
//        mBrushSize=TypedValue.applyDimension(COMPLEX_UNIT_DIP,newSize,resources.displayMetrics
//
//        )
//        mPaint!!.strokeWidth=mBrushSize
//    }
//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        var touchX =event?.x
//        var touchy=event?.y
//        when(event?.action){
//            MotionEvent.ACTION_DOWN ->{
//                mDrawPath!!.color=color
//                mDrawPath!!.BrushSize=10.toFloat()
//                mDrawPath!!.reset()
//                mDrawPath!!.moveTo(touchX!!,touchy!!)
//            }
//            MotionEvent.ACTION_MOVE->{
//                mDrawPath!!.lineTo(touchX!!,touchy!!)
//            }
//            MotionEvent.ACTION_UP->{
//                mDrawPath=CustomPath(color,mBrushSize)
//                mPaths.add(mDrawPath!!)
//            }
//            else ->{
//                return false
//            }
//        }
//
//        invalidate()
//
//        return true
//    }
//
//    internal inner  class CustomPath(var color:Int,var BrushSize:Float) :
//        android.graphics.Path(){
//
//    }
//}