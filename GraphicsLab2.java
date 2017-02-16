/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicslab2;

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
import java.util.StringTokenizer;

public class GraphicsLab2 implements GLEventListener {

    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) throws IOException {
        //getting the capabilities object of GL2 profile

        GraphicsLab2 l = new GraphicsLab2();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(1200, 1000);

        final JFrame frame = new JFrame("Point Canvas");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        //gl.glPointSize(1);
        gl.glBegin(GL2.GL_POINTS);//static field
        //gl.glPointSize(.5f);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("coordinates.txt")));
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer token = new StringTokenizer(line, " ");
                while (token.hasMoreTokens()) {
                    float a = Float.parseFloat(token.nextToken());
                    float b = Float.parseFloat(token.nextToken());
                    float c = Float.parseFloat(token.nextToken());
                    float d = Float.parseFloat(token.nextToken());
                    float x, y, w, z;
                    if (a < c) {
                        x = a;
                        y = b;
                        w = c;
                        z = d;
                    } else {
                        x = c;
                        y = d;
                        w = a;
                        z = b;
                    }
                    float dx = w - x;
                    float dy = z - y;
                    if (dx != 0) {
                        float slope = dy / dx;
                        if (-1 < slope && slope < 0) {
                            gl.glVertex2d(x, y);
                            float p = 2 * -1 * dy - dx;
                            while (x <= w) {
                                x += .0001;
                                if (p < 0) {
                                    // y -= .0001;
                                    p += 2 * -1 * dy;
                                } else {
                                    y -= .0001;
                                    p += 2 * (-1 * dy - dx);
                                }
                                gl.glVertex2d(x, y);
                            }
                        }
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException | NumberFormatException e) {

        }
        gl.glEnd();

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

