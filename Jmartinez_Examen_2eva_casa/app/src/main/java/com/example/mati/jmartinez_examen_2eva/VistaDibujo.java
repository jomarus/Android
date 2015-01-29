package com.example.mati.jmartinez_examen_2eva;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;

public class VistaDibujo extends View {
    public int x=280,y=300,ancho=100, alto=100;
    Paint paint = new Paint();
    Path path = new Path();
    private ShapeDrawable cabeza, lineaBrazos,lineaCuerpo, linePiernaD,linePiernaI;

    public VistaDibujo(Context context, AttributeSet attrs) {
        super(context, attrs);
        cabeza = new ShapeDrawable(new OvalShape());
        cabeza.getPaint().setColor(Color.YELLOW);
        cabeza.setBounds(x, y, x + ancho, y + alto);

        lineaBrazos = new ShapeDrawable(new RectShape());
        lineaBrazos.getPaint().setColor(Color.BLACK);
        lineaBrazos.setBounds(240, 450, 450, 460);

        lineaCuerpo = new ShapeDrawable(new RectShape());
        lineaCuerpo.getPaint().setColor(Color.BLACK);
        lineaCuerpo.setBounds(320, 400, 340, 530);

        linePiernaD = new ShapeDrawable(new RectShape());
        linePiernaD.getPaint().setColor(Color.BLACK);
        linePiernaD.setBounds(280, 700, 300, 850);

        linePiernaI = new ShapeDrawable(new RectShape());
        linePiernaI.getPaint().setColor(Color.BLACK);
        linePiernaI.setBounds(360, 700, 380, 850);

    }

    //Update
    protected void onDraw(Canvas canvas) {

        cabeza.draw(canvas);
        lineaBrazos.draw(canvas);
        lineaCuerpo.draw(canvas);
        linePiernaD.draw(canvas);
        linePiernaI.draw(canvas);

        paint.setStrokeWidth(2);
        paint.setColor(android.graphics.Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setShader(new LinearGradient(0, 0, 0, 700, Color.BLACK, Color.RED, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);

        Point a = new Point(330, 520);
        Point b = new Point(470, 700);
        Point c = new Point(220, 700);

        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(b.x,b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.lineTo(b.x, b.y);

        path.close();

        canvas.drawPath(path, paint);
        canvas.drawText("B "+b.x+","+b.y,b.x,b.y,paint);
        canvas.drawText("C "+c.x+","+c.y,c.x,c.y,paint);
        canvas.drawText("A "+a.x+","+a.y,a.x,a.y,paint);

        //invalidate();
    }
}
