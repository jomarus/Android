package com.photocad.ejerciciodibujos;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;

public class DrawingTheBall  extends View{

    BitmapDrawable ball;
    int x,y,sumadorx,sumadory;

    ShapeDrawable elipse;
    int ancho=300, alto=150;

    //Constructor llama a la vista Main
    public DrawingTheBall(Context context) {
        super(context);

        //Conseguir el recurso Ball
        Resources res= context.getResources();
        ball= (BitmapDrawable)res.getDrawable(R.drawable.ball);
        x=y=0;
        sumadorx=10;
        sumadory=10;

        //Crear Elipse
        elipse = new ShapeDrawable(new OvalShape());
        elipse.getPaint().setColor(Color.RED);
        elipse.setBounds(20, 30, x + ancho, y + alto);
    }

    //Alt + insert Override -> Generar Canvas donde dibujar
    @Override
    protected void onDraw(Canvas canvas) {

        //Crear rectangulo
        Rect rentangulo = new Rect();
        rentangulo.set(0,0,canvas.getWidth(),canvas.getHeight()/2);

        //Crear pinceles
        Paint blue = new Paint();
        Paint pincelPelota = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStyle(Paint.Style.FILL);


        //Movimiento de la pelota
        x +=sumadorx;
        y +=sumadory;

        //Las coordenadas se invierten al llegar al borde
        if(x>canvas.getWidth()-128 || x<0)
            sumadorx = -sumadorx;
        if(y>canvas.getHeight()-128 || y<0)
            sumadory = -sumadory;

        //Coordenadas de la pelota + dimensiones de la imagen
        ball.setBounds(x,y,x+128,y+128);

        //Añadir objetos al canvas
        canvas.drawRect(rentangulo,blue);
        ball.draw(canvas);
        elipse.draw(canvas);

        //Generar update infinito
        invalidate();
    }
}
