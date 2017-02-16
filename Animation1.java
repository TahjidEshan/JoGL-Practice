package animation1;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import java.awt.event.*;
import com.jogamp.opengl.util.Animator;

public class Animation1 implements GLEventListener, MouseListener {

    private double x1 = 0;
    private double y1 = 0;
    private double x2 = x1 + .3;
    private double y2 = y1 + .3;
    private double theta = .01;
    public static Animator animator;
    GLProfile glp;
    GLCapabilities caps;
    static GLCanvas canvas;
    JFrame frame;

    public Animation1() {
        glp = GLProfile.getDefault();
        caps = new GLCapabilities(glp);
        caps.setDoubleBuffered(true);
        canvas = new GLCanvas(caps);
        frame = new JFrame("Animation");
        frame.setSize(600, 600);
        frame.add(canvas);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Animation1 s = new Animation1();
        canvas.addGLEventListener(s);
        canvas.addMouseListener(s);
        // canvas.addGLEventListener(new Animation1());
        animator = new Animator(canvas);
        animator.start();
//        canvas.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent me) {
//                System.out.println(me);
//                x1 = me.getX()/800;
//                y1 = me.getY()/800;
//            }
//        });
    }

    @Override
    public void mousePressed(MouseEvent mouse) {
//        System.out.println(mouse);
        double x = mouse.getX();
        double y = mouse.getY();
        //  System.out.println(x);
        // System.out.println(y);
        x = x - 300;
        x = x / 300;
        y = 300 - y;
        y = y / 300;
        x1 = x;
        y1 = y;
        x2 = x1 + .3;
        y2 = y1 + .3;
    }

    @Override
    public void mouseExited(MouseEvent mouse) {
    }

    @Override
    public void mouseReleased(MouseEvent mouse) {
    }

    @Override
    public void mouseClicked(MouseEvent mouse) {
    }

    @Override
    public void mouseEntered(MouseEvent mouse) {
    }

    public double getX(double x, double y) {
        return x1 + ((x - x1) * Math.cos(theta) - (y - y1) * Math.sin(theta));
    }

    public double getY(double x, double y) {
        return y1 + ((x - x1) * Math.sin(theta) + (y - y1) * Math.cos(theta));
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
        x = getX(x1 + .1, y1 + .1);
        y = getY(x1 + .1, y1 + .1);
        gl.glVertex3d(x, y, 0);
        x = getX(x1 + .1, y2 + .1);
        y = getY(x1 + .1, y2 + .1);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2 + .1, y1 + .1);
        y = getY(x2 + .1, y1 + .1);
        gl.glVertex3d(x, y, 0);
        x = getX(x2 + .1, y2 + .1);
        y = getY(x2 + .1, y2 + .1);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2 + .1, y1 + .1);
        y = getY(x2 + .1, y1 + .1);
        gl.glVertex3d(x, y, 0);
        x = getX(x1 + .1, y1 + .1);
        y = getY(x1 + .1, y1 + .1);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2 + .1, y2 + .1);
        y = getY(x2 + .1, y2 + .1);
        gl.glVertex3d(x, y, 0);
        x = getX(x1 + .1, y2 + .1);
        y = getY(x1 + .1, y2 + .1);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x1, y1);
        y = getY(x1, y1);
        gl.glVertex3d(x, y, 0);
        x = getX(x1 + .1, y1 + .1);
        y = getY(x1 + .1, y1 + .1);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2, y2);
        y = getY(x2, y2);
        gl.glVertex3d(x, y, 0);
        x = getX(x2 + .1, y2 + .1);
        y = getY(x2 + .1, y2 + .1);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x1, y2);
        y = getY(x1, y2);
        gl.glVertex3d(x, y, 0);
        x = getX(x1 + .1, y2 + .1);
        y = getY(x1 + .1, y2 + .1);
        gl.glVertex3d(x, y, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        x = getX(x2, y1);
        y = getY(x2, y1);
        gl.glVertex3d(x, y, 0);
        x = getX(x2 + .1, y1 + .1);
        y = getY(x2 + .1, y1 + .1);
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
