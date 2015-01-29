package com.photocad.menusycanvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;


public class Dibujos extends Activity {

    public int x=200,y=200,ancho, alto;
    double area;
    public String value,value2,figura;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new VistaAMedida(this));
    }

    public class VistaAMedida extends View {
        private ShapeDrawable miDrawable;

        //Start
        public VistaAMedida(Context contexto) {
            super(contexto);

            value = getIntent().getExtras().getString("lado1");
            value2 = getIntent().getExtras().getString("lado2");
            ancho = Integer.parseInt(value);
            alto = Integer.parseInt(value2);
        }

        //Update
        protected void onDraw(Canvas canvas) {
            if(alto==-1) {
                miDrawable = new ShapeDrawable(new OvalShape());
                miDrawable.getPaint().setColor(0xff0000ff);
                miDrawable.setBounds(canvas.getWidth()/2-(ancho/2),canvas.getHeight()/2-(ancho/2),canvas.getWidth()/2+ancho,canvas.getHeight()/2+ancho);
                area=Math.round(Math.PI*Math.pow(ancho,2));
                figura="circulo";
            }else {
                miDrawable = new ShapeDrawable(new RectShape());
                miDrawable.getPaint().setColor(0xff0000ff);
                miDrawable.setBounds(canvas.getWidth()/2-(ancho/2),canvas.getHeight()/2-(alto/2),canvas.getWidth()/2+ancho,canvas.getHeight()/2+alto);
                area=ancho*alto;
                figura="rectangulo";
            }

            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setTextSize(36f);
            paint.setAntiAlias(true);

            miDrawable.draw(canvas);
            canvas.drawText("El area del "+figura+" es: "+area,canvas.getWidth()/2-220,canvas.getHeight()/2+150,paint);

        }
    }
}
