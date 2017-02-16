/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicsquiz;

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
import com.jogamp.opengl.util.Animator;

public class GraphicsQuiz implements GLEventListener {

    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    public static Animator animator;

    public static void main(String[] args) throws IOException {
        //getting the capabilities object of GL2 profile

        GraphicsQuiz l = new GraphicsQuiz();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(600, 600);

        final JFrame frame = new JFrame("CLOCK");
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
        glcanvas.addGLEventListener(new GraphicsQuiz());
        animator = new Animator(glcanvas);
        animator.start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        float h1, k1, r1;
        h1 = (float) 0;
        k1 = (float) 0;
        r1 = (float) 150;
        float x = r1;
        float y = 0f;
        float d = 1 - x;
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3d(0.1, .4, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_POINTS);
        draw8wayA(gl, x, y, h1, k1, 0, .2);
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
            x /= 400;
            y /= 400;
            gl.glBegin(GL2.GL_POINTS);
            draw8wayA(gl, x, y, h1, k1, 0, .2);
            gl.glEnd();
            x *= 400;
            y *= 400;
        }
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex3d(0.1, .4, 0);
        gl.glEnd();
    }

    public double formula(float x, float y, float h, float k, float r) {
        //System.out.println(x + " " + y + " " + h + " " + k + " " + r);
        double m = (x - h) * (x - h) + (y - k) * (y - k) - r * r;
        return m;
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

    public void draw8wayA(GL2 gl, float x, float y, float xc, float yc, double xl, double yl) {
        if (xc + x < xl && yc + y > yl) {
            gl.glVertex2d(xc + x, yc + y);
        }
        if (xc - y < xl && yc - x > yl) {
            gl.glVertex2d(xc - y, yc - x);
        }
        if (xc + y < xl && yc - x > yl) {
            gl.glVertex2d(xc + y, yc - x);
        }
        if (xc - y < xl && yc + x > yl) {
            gl.glVertex2d(xc - y, yc + x);
        }
        if (xc + y < xl && yc + x > yl) {
            gl.glVertex2d(xc + y, yc + x);
        }
        if (xc - x < xl && yc - y > yl) {
            gl.glVertex2d(xc - x, yc - y);
        }
        if (xc + x < xl && yc - y > yl) {
            gl.glVertex2d(xc + x, yc - y);
        }
        if (xc - x < xl && yc + y > yl) {
            gl.glVertex2d(xc - x, yc + y);
        }

    }

    public void drawLine(GL2 gl, float x, float y, float w, float z, int slope) {
        float dx = w - x;
        float dy = z - y;
        float d = 2 * dy - dx;
        float e = 2 * dy;
        float ne = 2 * (dy - dx);
        drawPoint(gl, x, y, slope);
        while (x <= w) {
            if (d < 0) {
                d += e;
                x += .0001;
            } else {
                d += ne;
                x += .0001;
                y += .0001;
            }
            drawPoint(gl, x, y, slope);
        }
    }

    public void drawPoint(GL2 gl, float x, float y, int slope) {
        if (slope == 0) {
            gl.glColor3d(1.1, 1.6, .1);
            gl.glVertex2d(x, y);
        } else if (slope == 1) {
            gl.glColor3d(1.0, 1.5, 1.2);
            gl.glVertex2d(y, x);
        } else if (slope == 2) {
            gl.glColor3d(1, 1, 1.0);
            gl.glVertex2d(-y, x);
        } else if (slope == 3) {
            gl.glColor3d(.6, 0.5, 1.9);
            gl.glVertex2d(-x, y);
        } else if (slope == 4) {
            gl.glColor3d(.4, 0.3, 1.0);
            gl.glVertex2d(-x, -y);
        } else if (slope == 5) {
            gl.glColor3d(.7, 0.3, 1.7);
            gl.glVertex2d(-y, -x);
        } else if (slope == 6) {
            gl.glColor3d(.9, 0.5, 2.0);
            gl.glVertex2d(y, -x);
        } else if (slope == 7) {
            gl.glColor3d(2.0, 0.5, 1.0);
            gl.glVertex2d(x, -y);
        }
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

