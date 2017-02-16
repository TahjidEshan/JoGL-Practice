
import javax.media.opengl.*;
import java.io.*;
import java.util.StringTokenizer;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.*;

/**
 * Created by Faysal on 31/01/2016.
 */
public class MidPointAlgorithm implements GLEventListener {

    static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas
    static GLCanvas glcanvas = new GLCanvas(capabilities);

    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile

        MidPointAlgorithm l = new MidPointAlgorithm();
        //creating frame
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(1000, 1200);

        final JFrame frame = new JFrame("straight Line");
        //adding canvas to frame
        frame.getContentPane().add(glcanvas);
        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glBegin(GL2.GL_POINTS);//static field

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("coordinates.txt")));
            String line = bufferedReader.readLine();
            while (line != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                while (stringTokenizer.hasMoreTokens()) {
                    float a = Float.parseFloat(stringTokenizer.nextToken());
                    float b = Float.parseFloat(stringTokenizer.nextToken());
                    float c = Float.parseFloat(stringTokenizer.nextToken());
                    float d = Float.parseFloat(stringTokenizer.nextToken());
                    float x0, y0, x1, y1;
                    if (a < c) {
                        x0 = a;
                        y0 = b;
                        x1 = c;
                        y1 = d;
                    } else {
                        x0 = c;
                        y0 = d;
                        x1 = a;
                        y1 = d;
                    }
                    float dx = x1 - x0;
                    float dy = y1 - y1;
                    double P0 = 2 * dy - dx;
                    double lower = 2 * dy;
                    double upper = 2 * (dy - dx);
                    gl.glVertex2d(x0, y0);

                    double P = P0;
                    double x = x0;
                    double y = y0;
                    while (x < x1) {
                        if (P <= 0) {
                            P += lower;
                        } else {
                            P += upper;
                            y++;
                        }
                        x++;
                        gl.glVertex2d(x, y);
                    }
                    gl.glVertex2d(x1, y1);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }
}
