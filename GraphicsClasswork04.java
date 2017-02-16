/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicslab02;

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
import java.util.Random;

public class GraphicsClasswork04 implements GLEventListener {

    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    double xMax = .6;
    double xMin = -.6;
    double yMax = .6;
    double yMin = -.6;

    public static void main(String[] args) throws IOException {
        //getting the capabilities object of GL2 profile

        GraphicsClasswork04 l = new GraphicsClasswork04();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(1200, 1000);

        final JFrame frame = new JFrame("Point Canvas");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }

    public int makeOutCode(float x, float y) {
        int outCode = 0;
        if (x < xMin) {
            outCode = outCode | 1;
        } else if (x > xMax) {
            outCode = outCode | 2;
        }
        if (y < yMin) {
            outCode = outCode | 4;
        } else if (y > yMax) {
            outCode = outCode | 8;
        }
        return outCode;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        //gl.glPointSize(1);
        gl.glBegin(GL2.GL_POINTS);//static field
        //gl.glPointSize(.5f);
        int count = 0;
        Random r = new Random();
        double minRange = -1.0;
        double maxRange = 1.0;
        while (count < 5000) {
            float x = (float) (minRange + (maxRange - minRange) * r.nextDouble());
            float y = (float) (minRange + (maxRange - minRange) * r.nextDouble());
            float w = (float) (minRange + (maxRange - minRange) * r.nextDouble());
            float z = (float) (minRange + (maxRange - minRange) * r.nextDouble());
            //float x = (float) .22;
            //float y = (float) .15;
            //float w = (float) -.1;
            //float z = (float) -.2;

            int outCode1 = makeOutCode(x, y);
            int outCode2 = makeOutCode(w, z);
            if ((outCode1 | outCode2) == 0) {
                gl.glColor3f(0.0f, 1.0f, 0.0f);
                // System.out.println("Accepted");
            } else if ((outCode1 & outCode2) > 0) {
                gl.glColor3f(1.0f, 0.0f, 0.0f);
                //System.out.println("Rejected");
            } else {
                gl.glColor3d(0.0f, 0.0f, 1.0f);
                //System.out.println("Trivial");
            }
            float dx = w - x;
            float dy = z - y;
            if (Math.abs(dx) >= Math.abs(dy)) {
                if (dx >= 0 && dy >= 0) {
                    drawLine(gl, x, y, w, z, 0);
                } else if (dx <= 0 && dy >= 0) {
                    drawLine(gl, -x, y, -w, z, 3);
                } else if (dx <= 0 && dy <= 0) {
                    drawLine(gl, -x, -y, -w, -z, 4);
                } else if (dx >= 0 && dy <= 0) {
                    drawLine(gl, x, -y, w, -z, 7);
                }
            } else {
                if (dx >= 0 && dy >= 0) {
                    drawLine(gl, y, x, z, w, 1);
                } else if (dx <= 0 && dy >= 0) {
                    drawLine(gl, y, -x, z, -w, 2);
                } else if (dx <= 0 && dy <= 0) {
                    drawLine(gl, -y, -x, -z, -w, 5);
                } else if (dx >= 0 && dy <= 0) {
                    drawLine(gl, -y, x, -z, w, 6);
                }
            }
            ++count;
        }

        gl.glEnd();

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
            //gl.glColor3d(1.1, 1.6, .1);
            gl.glVertex2d(x, y);
        } else if (slope == 1) {
            //gl.glColor3d(1.0, 1.5, 1.2);
            gl.glVertex2d(y, x);
        } else if (slope == 2) {
            //gl.glColor3d(1, 1, 1.0);
            gl.glVertex2d(-y, x);
        } else if (slope == 3) {
            //gl.glColor3d(.6, 0.5, 1.9);
            gl.glVertex2d(-x, y);
        } else if (slope == 4) {
            //gl.glColor3d(.4, 0.3, 1.0);
            gl.glVertex2d(-x, -y);
        } else if (slope == 5) {
            //gl.glColor3d(.7, 0.3, 1.7);
            gl.glVertex2d(-y, -x);
        } else if (slope == 6) {
            //gl.glColor3d(.9, 0.5, 2.0);
            gl.glVertex2d(y, -x);
        } else if (slope == 7) {
            //gl.glColor3d(2.0, 0.5, 1.0);
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

    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // method body
    }
   //end of main
}//end of classimport javax.media.opengl.GL2;

