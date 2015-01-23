package com.pruebas.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Peep on 21/01/2015.
 */
public class VistaDibujo extends View{
    public int x=20,y=20,ancho=300, alto=150;
    Paint paint = new Paint();
    Path path = new Path();
    private ShapeDrawable miDrawable;

    public VistaDibujo(Context context, AttributeSet attrs) {
        super(context, attrs);
        miDrawable = new ShapeDrawable(new OvalShape());
        miDrawable.getPaint().setColor(Color.CYAN);
        miDrawable.setBounds(x, y, x + ancho, y + alto);
    }

    //Update
    protected void onDraw(Canvas canvas) {

        miDrawable.draw(canvas);

        paint.setStrokeWidth(2);
        paint.setColor(android.graphics.Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        Point a = new Point(10, 50);
        Point b = new Point(150, 100);
        Point c = new Point(70, 480);

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
