/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicslab3;

/**
 *
 * @author eshan
 */
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.swing.JFrame;
import javax.media.opengl.awt.GLCanvas;
import java.io.*;

public class GraphicsLab3 implements GLEventListener {

    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) throws IOException {
        //getting the capabilities object of GL2 profile

        GraphicsLab3 l = new GraphicsLab3();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(600, 600);

        final JFrame frame = new JFrame("Circle");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        float x = 100f;
        float y = 0f;
        float d = 1 - x;
        gl.glBegin(GL2.GL_POINTS);
        draw8wayA(gl, x, y, -.5f, -.5f);
        draw8wayA(gl, x, y, 0, 0);
        gl.glEnd();
        while (y <= x) {
            if (d < 0) {
                d += (2 * y + 1);
                y += 0.0001;
            } else {
                d += (-2 * x) + 2 * y + 1;
                y += 0.0001;
                x -= 0.0001;
            }
            // x /= 400;
            //y /= 400;
            gl.glBegin(GL2.GL_POINTS);
            draw8wayA(gl, x, y, -.5f, -.5f);
            draw8wayA(gl, x, y, 0, 0);
            gl.glEnd();
            //x *= 400;
            //y *= 400;
        }

    }

//    public void draw8way(GL2 gl, float x, float y) {
//        gl.glVertex3d(x, y, 0);
//        gl.glVertex3d(-x, y, 0);
//        gl.glVertex3d(x, -y, 0);
//        gl.glVertex3d(-x, -y, 0);
//        gl.glVertex3d(y, x, 0);
//        gl.glVertex3d(y, -x, 0);
//        gl.glVertex3d(-y, x, 0);
//        gl.glVertex3d(-y, -x, 0);
//    }
    public void draw8wayA(GL2 gl, float x, float y, float xc, float yc) {
        gl.glVertex2d(xc + x, yc + y);
        gl.glVertex2d(xc - y, yc - x);
        gl.glVertex2d(xc + y, yc - x);
        gl.glVertex2d(xc - y, yc + x);
        gl.glVertex2d(xc + y, yc + x);
        gl.glVertex2d(xc - x, yc - y);
        gl.glVertex2d(xc + x, yc - y);
        gl.glVertex2d(xc - x, yc + y);

    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        //method body
    }

    /**
     *
     * @param drawable
     */
    @Override
    public void init(GLAutoDrawable drawable) {
        drawable.getGL().setSwapInterval(5);
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body
    }
   //end of main
}//end of classimport javax.media.opengl.GL2;

