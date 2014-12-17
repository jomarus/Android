package com.example.mati.dibujartriangulo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MyActivity extends Activity {

    public int x=20,y=20,ancho=300, alto=150;
    Paint paint = new Paint();
    Path path = new Path();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new VistaAMedida(this));
    }

    public class VistaAMedida extends View {
        private ShapeDrawable miDrawable;

        //Start
        public VistaAMedida(Context contexto) {
            super(contexto);
            miDrawable = new ShapeDrawable(new OvalShape());
            miDrawable.getPaint().setColor(0xff0000ff);
            miDrawable.setBounds(x, y, x + ancho, y + alto);
        }

        //Update
        protected void onDraw(Canvas canvas) {

            miDrawable.draw(canvas);

            paint.setStrokeWidth(2);
            paint.setColor(android.graphics.Color.RED);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);

            Point a = new Point(50, 50);
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
}
