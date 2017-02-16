
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.swing.JFrame;
import javax.media.opengl.awt.GLCanvas;
import java.io.*;
import java.util.StringTokenizer;

public class Line implements GLEventListener {

    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) throws IOException {
        //getting the capabilities object of GL2 profile

        Line l = new Line();
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
                    if ((z - y) == (w - x)) {
                        gl.glColor3d(1.1, 0.5, 1.1);
                        gl.glVertex2f(x, y);
                        double j = y + .001;
                        for (double i = x + .001; i < w; i = i + .001) {
                            gl.glVertex2d(i, j);
                            j = j + .001;
                        }
                        gl.glVertex2f(w, z);
                    } else if ((z - y) / (w - x) == -1) {
                        gl.glColor3d(0.1, 0.5, 1.1);
                        gl.glVertex2f(x, y);
                        double j = y - .001;
                        for (double i = x + .001; i < w; i = i + .001) {
                            gl.glVertex2d(i, j);
                            j = j - .001;
                        }
                        gl.glVertex2f(w, z);
                    } else if ((z - y) / (w - x) == 0) {
                        gl.glColor3d(0.1, 1.5, 1.1);
                        gl.glVertex2f(x, y);
                        for (double i = x + .001; i < w; i = i + .001) {
                            gl.glVertex2d(i, y);
                        }
                        gl.glVertex2f(w, z);
                    } else if (w - x == 0) {
                        gl.glColor3d(1.1, 1.5, 1.0);
                        gl.glVertex2f(x, y);
                        for (double i = y + .001; i < z; i = i + .001) {
                            gl.glVertex2d(x, i);
                        }
                        gl.glVertex2f(w, z);
                    } else {
                        System.out.println("Invalid Co ordinates");
                    }

                }
                line = reader.readLine();
            }
        } catch (IOException | NumberFormatException e) {

        }
        gl.glEnd();

    }

    /*
     public void display(GLAutoDrawable drawable) {
     final GL2 gl = drawable.getGL().getGL2();
     gl.glBegin(GL2.GL_POINTS);//static field
     gl.glVertex2d(0.5, 0.5);
     gl.glVertex2d(0.5, -0.5);
     gl.glVertex2d(-0.5, 0.5);
     gl.glVertex2d(-0.5, -0.5);
     gl.glEnd();

     }*/
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
