import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jogamp.opengl.util.Animator;

public class Animation implements GLEventListener {

    private final double x1 = 0;
    private final double y1 = 0;
    private final double x2 = .5;
    private final double y2 = .5;
    private double theta = .01;
    public static Animator animator;

    public static void main(String[] args) {
        Animation s = new Animation();
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        caps.setDoubleBuffered(true);
        GLCanvas canvas = new GLCanvas(caps);
        canvas.addGLEventListener(s);
        JFrame frame = new JFrame("Animation");
        frame.setSize(800, 800);
        frame.add(canvas);
        frame.setVisible(true);

        canvas.addGLEventListener(new Animation());
        animator = new Animator(canvas);
        animator.start();
    }

    public double getX(double x, double y) {
        return x * Math.cos(theta) - y * Math.sin(theta);
    }

    public double getY(double x, double y) {
        return x * Math.sin(theta) + y * Math.cos(theta);
    }

    @Override
    public void display(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();
        theta += .01;
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glBegin(GL2.GL_LINES);
        double x = getX(x1, y1);
        double y = getY(x1, y1);
        gl.glVertex3d(x, y, 0);
        x = getX(x1, y2);
        y = getY(x1, y2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2, y1);
        y = getY(x2, y1);
        gl.glVertex3d(x, y, 0);
        y = getY(x2, y2);
        x = getX(x2, y2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2, y1);
        y = getY(x2, y1);
        gl.glVertex3d(x, y, 0);
        x = getX(x1, y1);
        y = getY(x1, y1);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2, y2);
        y = getY(x2, y2);
        gl.glVertex3d(x, y, 0);
        x = getX(x1, y2);
        y = getY(x1, y2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x1 + .2, y1 + .2);
        y = getY(x1 + .2, y1 + .2);
        gl.glVertex3d(x, y, 0);
        x = getX(x1 + .2, y2 + .2);
        y = getY(x1 + .2, y2 + .2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2 + .2, y1 + .2);
        y = getY(x2 + .2, y1 + .2);
        gl.glVertex3d(x, y, 0);
        x = getX(x2 + .2, y2 + .2);
        y = getY(x2 + .2, y2 + .2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2 + .2, y1 + .2);
        y = getY(x2 + .2, y1 + .2);
        gl.glVertex3d(x, y, 0);
        x = getX(x1 + .2, y1 + .2);
        y = getY(x1 + .2, y1 + .2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2 + .2, y2 + .2);
        y = getY(x2 + .2, y2 + .2);
        gl.glVertex3d(x, y, 0);
        x = getX(x1 + .2, y2 + .2);
        y = getY(x1 + .2, y2 + .2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x1, y1);
        y = getY(x1, y1);
        gl.glVertex3d(x, y, 0);
        x = getX(x1 + .2, y1 + .2);
        y = getY(x1 + .2, y1 + .2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2, y2);
        y = getY(x2, y2);
        gl.glVertex3d(x, y, 0);
        x = getX(x2 + .2, y2 + .2);
        y = getY(x2 + .2, y2 + .2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x1, y2);
        y = getY(x1, y2);
        gl.glVertex3d(x, y, 0);
        x = getX(x1 + .2, y2 + .2);
        y = getY(x1 + .2, y2 + .2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2, y1);
        y = getY(x2, y1);
        gl.glVertex3d(x, y, 0);
        x = getX(x2 + .2, y1 + .2);
        y = getY(x2 + .2, y1 + .2);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        drawable.getGL().setSwapInterval(1);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    }

}
