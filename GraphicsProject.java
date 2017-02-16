package graphicsproject;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import java.awt.event.*;
import com.jogamp.opengl.util.Animator;
import javax.swing.WindowConstants;

public class GraphicsProject implements GLEventListener, MouseListener {

    private final double x1 = .6;
    private final double y1 = .7;
    private final double x2 = .6;
    private final double y2 = .85;
    private final double y3 = .8;
    private double theta = .01;
    private double delta = .01;
    private int count = 0;
    public static Animator animator;
    GLProfile glp;
    GLCapabilities caps;
    static GLCanvas canvas;
    JFrame frame;
    GL2 gl;
    double val = -.6;
    int c = 0;
    int branchCOunt = 0;
    double branchVal1 = -0.81;
    double branchVal2 = -0.69;
    double branchVal3 = -0.81;
    double branchVal4 = -0.69;
    double branchVal5 = -0.81;
    double branchVal6 = -0.69;
    double branchVal7 = -0.81;
    double branchVal8 = -0.69;
    int value = 1;
    private double sigma = .01;
    boolean bool = true;
    int eye = 0;
    int loop = 0;
    double c1r = 0.01, c2r = 0.01, c3r = 0.01, c4r = 0.01, c5r = 0.01, c6r = 0.01;
    double l1 = 0, l2 = 0, l3 = 0, l4 = 0, l5 = 0, l6 = 0;
    double batX = -.6;
    double batY = .6;
    boolean bat = true, gammaV = true;
    double ca = .62, cb = .58, cc = .3, h1 = .6, r1 = .3, gamma = .06;

    public GraphicsProject() {
        glp = GLProfile.getDefault();
        caps = new GLCapabilities(glp);
        caps.setDoubleBuffered(true);
        canvas = new GLCanvas(caps);
        frame = new JFrame("GRAPHICS PROJECT");
        frame.setSize(600, 600);
        frame.add(canvas);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GraphicsProject s = new GraphicsProject();
        canvas.addGLEventListener(s);
        canvas.addMouseListener(s);
        animator = new Animator(canvas);
        animator.start();
    }

    @Override
    public void mousePressed(MouseEvent mouse) {
        double x = mouse.getX();
        double y = mouse.getY();
        x = x - 300;
        x = x / 300;
        y = 300 - y;
        y = y / 300;
        batX = x;
        batY = y;
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

    public double getX(double x, double y, double val) {
        return x1 + ((x - x1) * Math.cos(val) - (y - y1) * Math.sin(val));
    }

    public double getY(double x, double y, double val) {
        return y1 + ((x - x1) * Math.sin(val) + (y - y1) * Math.cos(val));
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        theta -= .06;
        c++;
        count++;
        if (count == 60) {
            delta -= .06;
            count = 0;
        }
        gl.glColor3d(1, 1, 1);
        drawCircleA(0, 0, 100);
        gl.glColor3d(.5, .5, 1);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(-1, 1, 0);
        gl.glVertex3d(-.25, 1, 0);
        gl.glVertex3d(-.25, 0, 0);
        gl.glVertex3d(-1, -1, 0);
        gl.glEnd();
        gl.glColor3d(.5, .5, 0.7);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(1, 1, 0);
        gl.glVertex3d(-.25, 1, 0);
        gl.glVertex3d(-.25, 0, 0);
        gl.glVertex3d(1, 0, 0);
        gl.glEnd();
        gl.glColor3d(.5, .5, .5);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(1, 0, 0);
        gl.glVertex3d(-.25, 0, 0);
        gl.glVertex3d(-1, -1, 0);
        gl.glVertex3d(1, -1, 0);
        gl.glEnd();
        gl.glColor3d(1, 1, 1);
        gl.glBegin(GL2.GL_POINTS);
        drawLine(gl, 0, 0, -.7, -1);
        drawLine(gl, .25, 0, -.4, -1);
        drawLine(gl, .5, 0, -.1, -1);
        drawLine(gl, .75, 0, .2, -1);
        drawLine(gl, 1, 0, .5, -1);
        drawLine(gl, 1.25, 0, .8, -1);
        drawLine(gl, 1, -.2, -.39, -.2);
        drawLine(gl, 1, -.4, -.55, -.4);
        drawLine(gl, 1, -.6, -.69, -.6);
        drawLine(gl, 1, -.8, -.84, -.8);
        drawLine(gl, -.25, 0, -1, -1);
        drawLine(gl, -.25, 0, 1, 0);
        gl.glEnd();
        gl.glColor3d(.8, .8, .8);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(.7, .6, 0);
        gl.glVertex3d(.5, .6, 0);
        gl.glVertex3d(.5, 0, 0);
        gl.glVertex3d(.7, 0, 0);
        gl.glEnd();
        gl.glColor3d(0, 0, 0);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(.75, .05, 0);
        gl.glVertex3d(.45, .05, 0);
        gl.glVertex3d(.45, 0, 0);
        gl.glVertex3d(.75, 0, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(.5, .6, 0);
        gl.glVertex3d(.5, 0, 0);
        gl.glVertex3d(.48, 0, 0);
        gl.glVertex3d(.48, 0.6, 0);
        gl.glEnd();
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(.7, .6, 0);
        gl.glVertex3d(.7, 0, 0);
        gl.glVertex3d(.715, 0, 0);
        gl.glVertex3d(.715, 0.6, 0);
        gl.glEnd();
        gl.glColor3d(.5, .5, .3);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(getX(ca, .6, gamma), getY(ca, .6, gamma), 0);
        gl.glVertex3d(getX(ca - .01, cc - .01, gamma), getY(ca - .01, cc - .01, gamma), 0);
        gl.glVertex3d(getX(cb, cc, gamma), getY(cb, cc, gamma), 0);
        gl.glVertex3d(getX(cb, .6, gamma), getY(cb, .6, gamma), 0);
        gl.glVertex3d(getX(cb + .01, cc - .01, gamma), getY(cb + .01, cc - .01, gamma), 0);
        gl.glVertex3d(getX(ca, cc, gamma), getY(ca, cc, gamma), 0);
        gl.glEnd();
        drawCircleA(getX(h1, r1, gamma), getY(h1, r1, gamma), .05);
        if (gamma <= -.12) {
            gammaV = false;

        } else if (gamma >= .12) {
            gammaV = true;
        }
        if (gammaV) {
            gamma -= .03;
        } else {
            gamma += .03;
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
        }
        if (value % 5 != 0) {
            value++;
            if (c % 2 == 0) {
                double ypad = .2;
                double xpad = -0.2;
                gl.glColor3d(.7, 0, 0);
                drawCircleA(0 - xpad, 0 - ypad, .4);
                gl.glColor3d(1, 1, 1);
                drawCircleA(-.2 - xpad, 0.2 - ypad, .07);
                drawCircleA(0.2 - xpad, 0.2 - ypad, .07);
                gl.glColor3d(.7, 0, 0);
                gl.glBegin(GL2.GL_POINTS);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(0.1 - xpad, -0.39 - ypad, 0);
                gl.glVertex3d(0.1 - xpad, -0.9 - ypad, 0);
                gl.glVertex3d(0.08 - xpad, -0.9 - ypad, 0);
                gl.glVertex3d(0.08 - xpad, -0.39 - ypad, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(-0.1 - xpad, -0.39 - ypad, 0);
                gl.glVertex3d(-0.1 - xpad, -0.9 - ypad, 0);
                gl.glVertex3d(-0.08 - xpad, -0.9 - ypad, 0);
                gl.glVertex3d(-0.08 - xpad, -0.39 - ypad, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(-0.4 - xpad, 0 - ypad, 0);
                gl.glVertex3d(-0.75 - xpad, 0 - ypad, 0);
                gl.glVertex3d(-0.75 - xpad, -0.02 - ypad, 0);
                gl.glVertex3d(-0.4 - xpad, -0.02 - ypad, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(0.4 - xpad, 0 - ypad, 0);
                gl.glVertex3d(0.75 - xpad, 0 - ypad, 0);
                gl.glVertex3d(0.75 - xpad, -0.01 - ypad, 0);
                gl.glVertex3d(0.4 - xpad, -0.01 - ypad, 0);
                gl.glEnd();
                gl.glColor3d(0, 0, 0);
                gl.glBegin(GL2.GL_TRIANGLES);
                gl.glVertex3d(.05, -.2 - ypad, 0);
                gl.glVertex3d(.35, -.2 - ypad, 0);
                gl.glVertex3d(.2, -.22 - ypad, 0);
                gl.glEnd();
                gl.glColor3d(0, 0, 0);
                gl.glBegin(GL2.GL_POLYGON);

                gl.glVertex3d(-.2, .5 - ypad, 0);
                gl.glVertex3d(-.15, .2 - ypad, 0);
                gl.glVertex3d(-.1, .26 - ypad, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);

                gl.glVertex3d(.55, .2 - ypad, 0);
                gl.glVertex3d(.6, .5 - ypad, 0);
                gl.glVertex3d(.5, .26 - ypad, 0);
                gl.glEnd();
            } else {
                gl.glColor3d(0.7, 0, 0);
                drawCircleA(0.2, 0, 0.4);
                gl.glColor3d(1, 1, 1);
                drawCircleA(0, 0.2, 0.07);
                drawCircleA(0.4, 0.2, 0.07);
                gl.glColor3d(0, 0, 1);
                drawCircleA(0, 0.2, .04);
                drawCircleA(0.4, 0.2, .04);
                gl.glColor3d(0.7, 0, 0);
                //left arm

                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(-.2, 0, 0);
                gl.glVertex3d(-.3, -.25, 0);
                gl.glVertex3d(-.3, -.29, 0);
                gl.glVertex3d(-.2, -.03, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(-.3, -.25, 0);
                gl.glVertex3d(-.3, -.45, 0);
                gl.glVertex3d(-.29, -.45, 0);
                gl.glVertex3d(-.29, -.25, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(.6, 0, 0);
                gl.glVertex3d(.7, -.25, 0);
                gl.glVertex3d(.7, -.29, 0);
                gl.glVertex3d(.6, -.04, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(.69, -.25, 0);
                gl.glVertex3d(.7, -.25, 0);
                gl.glVertex3d(.7, -.45, 0);
                gl.glVertex3d(.69, -.45, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(.4, -.65, 0);
                gl.glVertex3d(.3, -.39, 0);
                gl.glVertex3d(.32, -.39, 0);
                gl.glVertex3d(.38, -.65, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(.4, -.65, 0);
                gl.glVertex3d(.3, -.9, 0);
                gl.glVertex3d(.32, -.9, 0);
                gl.glVertex3d(.38, -.65, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(.0, -.65, 0);
                gl.glVertex3d(.02, -.65, 0);
                gl.glVertex3d(.08, -.39, 0);
                gl.glVertex3d(.1, -.39, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(.0, -.65, 0);
                gl.glVertex3d(.01, -.65, 0);
                gl.glVertex3d(.11, -.9, 0);
                gl.glVertex3d(.1, -.9, 0);
                gl.glEnd();
                gl.glColor3d(0, 0, 0);
                gl.glBegin(GL2.GL_POLYGON);
                gl.glVertex3d(.05, -.2, 0);
                gl.glVertex3d(.35, -.2, 0);
                gl.glVertex3d(.2, -.22, 0);
                gl.glEnd();

                gl.glBegin(GL2.GL_POLYGON);

                gl.glVertex3d(-.2, .5, 0);
                gl.glVertex3d(-.15, 0.2, 0);
                gl.glVertex3d(-.1, 0.26, 0);
                gl.glEnd();
                gl.glBegin(GL2.GL_POLYGON);

                gl.glVertex3d(.55, .2, 0);
                gl.glVertex3d(.5, 0.26, 0);
                gl.glVertex3d(.6, 0.5, 0);
                gl.glEnd();
            }

        } else if (value % 5 == 0) {
            loop++;
            if (loop > 5) {
                loop = 0;
                value++;
            }
            if (bool) {
                sigma -= .06;
                if (sigma < -.1) {
                    bool = false;
                }
            } else {
                sigma += .06;
                if (sigma > .08) {
                    bool = true;
                }
            }
            eye++;

            double ypad = .2;
            double xpad = -0.2;
            gl.glColor3d(.8, 0, 0);
            drawCircleA(getX(0 - xpad, 0 - ypad, sigma), getY(0 - xpad, 0 - ypad, sigma), 0.4);
            gl.glColor3d(1, 1, 1);
            drawCircleA(getX(-0.2 - xpad, .2 - ypad, sigma), getY(-0.2 - xpad, .2 - ypad, sigma), 0.07);
            drawCircleA(getX(0.2 - xpad, .2 - ypad, sigma), getY(0.2 - xpad, .2 - ypad, sigma), 0.07);
            gl.glColor3d(0, 0, 1);
            if (eye % 2 == 0) {
                drawCircleA(getX(-0.2 - xpad, .2 - ypad, sigma), getY(-0.2 - xpad, .2 - ypad, sigma), 0.04);
                drawCircleA(getX(0.2 - xpad, .2 - ypad, sigma), getY(0.2 - xpad, .2 - ypad, sigma), 0.04);
            }
            gl.glColor3d(.7, 0, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(getX(0.1 - xpad, -0.38 - ypad, sigma), getY(0.1 - xpad, -0.38 - ypad, sigma), 0);
            gl.glVertex3d(0.1 - xpad, -0.9 - ypad, 0);
            gl.glVertex3d(0.12 - xpad, -0.9 - ypad, 0);
            gl.glVertex3d(getX(0.12 - xpad, -0.38 - ypad, sigma), getY(0.12 - xpad, -0.38 - ypad, sigma), 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(getX(-0.1 - xpad, -0.38 - ypad, sigma), getY(-0.1 - xpad, -0.38 - ypad, sigma), 0);
            gl.glVertex3d(-0.1 - xpad, -0.9 - ypad, 0);
            gl.glVertex3d(-0.12 - xpad, -0.9 - ypad, 0);
            gl.glVertex3d(getX(-0.12 - xpad, -0.38 - ypad, sigma), getY(-0.12 - xpad, -0.38 - ypad, sigma), 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(getX(-0.4 - xpad, 0 - ypad, sigma), getY(-0.4 - xpad, 0 - ypad, sigma), 0);
            gl.glVertex3d(getX(-0.75 - xpad, 0 - ypad, sigma), getY(-0.75 - xpad, 0 - ypad, sigma), 0);
            gl.glVertex3d(getX(-0.75 - xpad, 0.02 - ypad, sigma), getY(-0.75 - xpad, 0.02 - ypad, sigma), 0);
            gl.glVertex3d(getX(-0.4 - xpad, 0.02 - ypad, sigma), getY(-0.4 - xpad, 0.02 - ypad, sigma), 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(getX(0.4 - xpad, 0 - ypad, sigma), getY(0.4 - xpad, 0 - ypad, sigma), 0);
            gl.glVertex3d(getX(0.75 - xpad, 0 - ypad, sigma), getY(0.75 - xpad, 0 - ypad, sigma), 0);
            gl.glVertex3d(getX(0.75 - xpad, 0.02 - ypad, sigma), getY(0.75 - xpad, 0.02 - ypad, sigma), 0);
            gl.glVertex3d(getX(0.4 - xpad, 0.02 - ypad, sigma), getY(0.4 - xpad, 0.02 - ypad, sigma), 0);
            gl.glEnd();

            gl.glColor3d(0, 0, 0);

            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(getX(.05, -.2 - ypad, sigma), getY(.05, -.2 - ypad, sigma), 0);
            gl.glVertex3d(getX(.35, -.2 - ypad, sigma), getY(.35, -.2 - ypad, sigma), 0);
            gl.glVertex3d(getX(.2, -.22 - ypad, sigma), getY(.2, -.22 - ypad, sigma), 0);
            gl.glEnd();

            gl.glBegin(GL2.GL_POLYGON);

            gl.glVertex3d(getX(-.2, .5 - ypad, sigma), getY(-.2, .5 - ypad, sigma), 0);
            gl.glVertex3d(getX(-.15, 0.2 - ypad, sigma), getY(-0.15, .2 - ypad, sigma), 0);
            gl.glVertex3d(getX(-.1, .26 - ypad, sigma), getY(-.1, 0.26 - ypad, sigma), 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);

            gl.glVertex3d(getX(.55, .2 - ypad, sigma), getY(.55, .2 - ypad, sigma), 0);
            gl.glVertex3d(getX(.6, 0.5 - ypad, sigma), getY(.6, .5 - ypad, sigma), 0);
            gl.glVertex3d(getX(.5, 0.26 - ypad, sigma), getY(.5, 0.26 - ypad, sigma), 0);
            gl.glEnd();
        }
        gl.glColor3d(0, 0, 0);
        drawCircleA(.6, .7, .17);
        gl.glColor3d(1, 1, 1);
        drawCircleA(.6, .7, .15);
        gl.glColor3d(0, 0, 0);
        gl.glBegin(GL2.GL_POINTS);
        drawCircle(gl, 0, .15, .6, .7, .15);
        gl.glEnd();
        gl.glBegin(GL2.GL_LINES);
        gl.glColor3d(0, 0, 1);
        gl.glVertex2d(x1, y1);
        gl.glVertex2d(getX(x2, y2, theta), getY(x2, y2, theta));
        gl.glEnd();

        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(x1, y1);
        gl.glVertex2d(getX(x2, y3, delta), getY(x2, y3, delta));
        gl.glEnd();

        gl.glColor3d(1, 1, 0.3);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(-.9, -.6, 0);
        gl.glVertex3d(-.85, -.65, 0);
        gl.glVertex3d(-.65, -.65, 0);
        gl.glVertex3d(-.6, -.6, 0);
        gl.glEnd();

        gl.glColor3d(1, 1, 0.4);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3d(-.83, -.9, 0);
        gl.glVertex3d(-.85, -.65, 0);
        gl.glVertex3d(-.65, -.65, 0);
        gl.glVertex3d(-.67, -.9, 0);
        gl.glEnd();
        gl.glColor3d(1, 1, 1);
        if (val > .1) {
            val = -.6;
            branchVal1 = -.81;
            branchVal2 = -.69;
            branchVal3 = -0.81;
            branchVal4 = -0.69;
            branchVal5 = -0.81;
            branchVal6 = -0.69;
            branchVal7 = -0.81;
            branchVal8 = -0.69;
            c1r = 0.01;
            c2r = 0.01;
            c3r = 0.01;
            c4r = 0.01;
            c5r = 0.01;
            c6r = 0.01;
            l1 = 0;
            l2 = 0;
            l3 = 0;
            l4 = 0;
            l5 = 0;
            l6 = 0;

        } else {
            val += .1;
        }

        gl.glColor3d(.5, .35, .05);
        gl.glBegin(GL2.GL_POLYGON);
        gl.glVertex3d(-.73, -.6, 0);
        gl.glVertex3d(-.75, val + .01, 0);
        gl.glVertex3d(-.77, -.6, 0);
        gl.glVertex3d(-.77, val, 0);
        gl.glVertex3d(-.75, val + .01, 0);
        gl.glVertex3d(-.73, val, 0);
        gl.glEnd();
        gl.glColor3d(1, 1, 1);
        if (val > -.5) {
            gl.glBegin(GL2.GL_POINTS);
            gl.glColor3d(.5, .35, .05);
            drawLine(gl, -.77, -.5, branchVal1, -.48);
            gl.glEnd();
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(branchVal1, -.48, 0);
            gl.glVertex3d(branchVal1 - .02 - l1, -.47 + l1, 0);
            gl.glVertex3d(branchVal1 - .04 - 2 * l1, -.48, 0);
            gl.glVertex3d(branchVal1 - .02 - l1, -.49 - l1, 0);
            gl.glEnd();
            l1 += .003;
            gl.glColor3d(.5, .35, .05);
            gl.glBegin(GL2.GL_POINTS);
            drawLine(gl, branchVal1 - .005, -.51, branchVal1 - .005, -.48);
            gl.glEnd();
            gl.glColor3d(1, 0, 0);
            drawCircleA(branchVal1 - .005, -.53, c1r);
            gl.glColor3d(1, 1, 1);
            branchVal1 -= .01;
            c1r += .003;
            gl.glBegin(GL2.GL_POINTS);
            gl.glColor3d(.5, .35, .05);
            drawLine(gl, -.73, -.5, branchVal2, -.48);
            drawLine(gl, branchVal2 + .005, -.51, branchVal2 + .005, -.48);
            gl.glEnd();
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(branchVal2, -.48, 0);
            gl.glVertex3d(branchVal2 + .02 + l2, -.47 + l2, 0);
            gl.glVertex3d(branchVal2 + .04 + 2 * l2, -.48, 0);
            gl.glVertex3d(branchVal2 + .02 + l2, -.49 - l2, 0);
            gl.glEnd();
            l2 += .003;
            gl.glColor3d(0, 0, 1);
            drawCircleA(branchVal2 + .005, -.53, c2r);
            gl.glColor3d(1, 1, 1);
            branchVal2 += .01;
            c2r += .003;
        }
        if (val > -.3) {
            gl.glBegin(GL2.GL_POINTS);
            gl.glColor3d(.5, .35, .05);
            drawLine(gl, -.77, -.3, branchVal3, -.28);
            drawLine(gl, branchVal3 - .005, -.31, branchVal3 - .005, -.28);
            gl.glEnd();
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(branchVal3, -.28, 0);
            gl.glVertex3d(branchVal3 - .02 - l3, -.27 + l3, 0);
            gl.glVertex3d(branchVal3 - .04 - 2 * l3, -.28, 0);
            gl.glVertex3d(branchVal3 - .02 - l3, -.29 - l3, 0);
            gl.glEnd();
            l3 += .003;
            gl.glColor3d(0, 1, .6);
            drawCircleA(branchVal3 - .005, -.33, c3r);
            gl.glColor3d(1, 1, 1);
            branchVal3 -= .01;
            c3r += .003;
            gl.glBegin(GL2.GL_POINTS);
            gl.glColor3d(.5, .35, .05);
            drawLine(gl, -.73, -.3, branchVal4, -.28);
            drawLine(gl, branchVal4 + .005, -.31, branchVal4 + .005, -.28);
            gl.glEnd();
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(branchVal4, -.28, 0);
            gl.glVertex3d(branchVal4 + .02 + l4, -.27 + l4, 0);
            gl.glVertex3d(branchVal4 + .04 + 2 * l4, -.28, 0);
            gl.glVertex3d(branchVal4 + .02 + l4, -.29 - l4, 0);
            gl.glEnd();
            l4 += .003;
            gl.glColor3d(1, 1, 0);
            drawCircleA(branchVal4 + .005, -.33, c4r);
            gl.glColor3d(1, 1, 1);
            branchVal4 += .01;
            c4r += .003;
        }
        if (val > -.1) {
            gl.glBegin(GL2.GL_POINTS);
            gl.glColor3d(.5, .35, .05);
            drawLine(gl, -.77, -.1, branchVal5, -.08);
            drawLine(gl, branchVal5 - .005, -.11, branchVal5 - .005, -.08);
            gl.glEnd();
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(branchVal5, -.08, 0);
            gl.glVertex3d(branchVal5 - .02 - l5, -.07 + l5, 0);
            gl.glVertex3d(branchVal5 - .04 - 2 * l5, -.08, 0);
            gl.glVertex3d(branchVal5 - .02 - l5, -.09 - l5, 0);
            gl.glEnd();
            l5 += .003;
            gl.glColor3d(0, 1, 1);
            drawCircleA(branchVal5 - .005, -.13, c5r);
            gl.glColor3d(1, 1, 1);
            branchVal5 -= .01;
            c5r += .003;
            gl.glBegin(GL2.GL_POINTS);
            gl.glColor3d(.5, .35, .05);
            drawLine(gl, -.73, -.1, branchVal6, -.08);
            drawLine(gl, branchVal6 + .005, -.11, branchVal6 + .005, -.08);
            gl.glEnd();
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(branchVal6, -.08, 0);
            gl.glVertex3d(branchVal6 + .02 + l6, -.07 + l6, 0);
            gl.glVertex3d(branchVal6 + .04 + 2 * l6, -.08, 0);
            gl.glVertex3d(branchVal6 + .02 + l6, -.09 - l6, 0);
            gl.glEnd();
            gl.glColor3d(1, 0, 1);
            drawCircleA(branchVal6 + .005, -.13, c6r);
            gl.glColor3d(1, 1, 1);
            branchVal6 += .01;
            c6r += .003;
        }
        if (val > 0.1) {
            gl.glBegin(GL2.GL_POINTS);
            gl.glColor3d(.5, .35, .05);
            drawLine(gl, -.77, .1, branchVal7, .12);
            gl.glEnd();
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(branchVal7, .12, 0);
            gl.glVertex3d(branchVal7 - .02, .11, 0);
            gl.glVertex3d(branchVal7 - .04, .12, 0);
            gl.glVertex3d(branchVal7 - .02, .13, 0);
            gl.glEnd();
            branchVal7 -= .01;
            gl.glColor3d(.5, .35, .05);
            gl.glBegin(GL2.GL_POINTS);
            drawLine(gl, -.73, .1, branchVal8, .12);
            gl.glEnd();
            gl.glColor3d(0, 1, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(branchVal8, .12, 0);
            gl.glVertex3d(branchVal8 + .02, .11, 0);
            gl.glVertex3d(branchVal8 + .04, .12, 0);
            gl.glVertex3d(branchVal8 + .02, .13, 0);
            gl.glEnd();
            gl.glColor3d(1, 1, 1);
            branchVal8 += .01;
            gl.glEnd();

        }
        if (bat) {
            bat = false;
            gl.glColor3d(0, 0, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(batX - .05, batY + .05, 0);
            gl.glVertex3d(batX - .15, batY - .09, 0);
            gl.glVertex3d(batX - .05, batY, 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(batX - .05, batY + .05, 0);
            gl.glVertex3d(batX, batY, 0);
            gl.glVertex3d(batX, batY - .05, 0);
            gl.glVertex3d(batX - .05, batY, 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(batX + .05, batY + .05, 0);
            gl.glVertex3d(batX, batY, 0);
            gl.glVertex3d(batX, batY - .05, 0);
            gl.glVertex3d(batX + .05, batY, 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(batX + .05, batY + .05, 0);
            gl.glVertex3d(batX + .05, batY, 0);
            gl.glVertex3d(batX + .15, batY - .09, 0);
            gl.glEnd();
            drawCircleA(batX, batY + .01, .015);
        } else {
            bat = true;
            gl.glColor3d(0, 0, 0);
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(batX - .05, batY + .05 - .01, 0);
            gl.glVertex3d(batX - .19, batY - .05 - .01, 0);
            gl.glVertex3d(batX - .05, batY - .01, 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(batX - .05, batY + .05 - .01, 0);
            gl.glVertex3d(batX, batY - .01, 0);
            gl.glVertex3d(batX, batY - .05 - .01, 0);
            gl.glVertex3d(batX - .05, batY - .01, 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(batX + .05, batY + .05 - .01, 0);
            gl.glVertex3d(batX, batY - .01, 0);
            gl.glVertex3d(batX, batY - .05 - .01, 0);
            gl.glVertex3d(batX + .05, batY - .01, 0);
            gl.glEnd();
            gl.glBegin(GL2.GL_POLYGON);
            gl.glVertex3d(batX + .05, batY + .05 - .01, 0);
            gl.glVertex3d(batX + .05, batY - .01, 0);
            gl.glVertex3d(batX + .19, batY - .05 - .01, 0);
            gl.glEnd();
            drawCircleA(batX, batY - .01 + .01, .015);
        }

    }

    public void drawCircleA(double x1, double y1, double radius) {
        double angle, x, y;
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        gl.glVertex2d(x1, y1);
        for (angle = 0.0; angle < 361; angle += .02) {
            x = x1 + Math.sin(angle) * radius;
            y = y1 + Math.cos(angle) * radius;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
    }

    private void draw8way(GL2 gl, double x, double y, double x_cen, double y_cen) {
        gl.glVertex2d(x + x_cen, y + y_cen);
        gl.glVertex2d(y + x_cen, x + y_cen);
        gl.glVertex2d(-y + x_cen, x + y_cen);
        gl.glVertex2d(-x + x_cen, y + y_cen);
        gl.glVertex2d(-x + x_cen, -y + y_cen);
        gl.glVertex2d(-y + x_cen, -x + y_cen);
        gl.glVertex2d(y + x_cen, -x + y_cen);
        gl.glVertex2d(x + x_cen, -y + y_cen);
    }

    private void drawCircle(GL2 gl, double x, double y, double x_cen, double y_cen, double r) {
        draw8way(gl, x, y, x_cen, y_cen);
        double d = (5 / 4) - r;
        while (x < y) {
            if (d < 0) {//de
                d += (2 * x * 10000 + 3);
                x = x + 0.00001;
            } else {//dse
                d += (2 * x * 10000 - 2 * y * 10000 + 5);
                x = x + 0.00001;
                y = y - 0.00001;
            }
            draw8way(gl, x, y, x_cen, y_cen);
        }
    }

    private void drawLine(GL2 gl, double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        if (Math.abs(dx) >= Math.abs(dy)) {
            if (dx >= 0 && dy >= 0) {
                draw(gl, x1, y1, x2, y2, 0);
            } else if (dx >= 0 && dy <= 0) {
                draw(gl, x1, -y1, x2, -y2, 7);
            } else if (dx <= 0 && dy >= 0) {
                draw(gl, -x1, y1, -x2, y2, 3);
            } else if (dx <= 0 && dy <= 0) {
                draw(gl, -x1, -y1, -x2, -y2, 4);
            }
        } else {
            if (dx >= 0 && dy >= 0) {
                draw(gl, y1, x1, y2, x2, 1);
            } else if (dx >= 0 && dy <= 0) {
                draw(gl, -y1, x1, -y2, x2, 6);
            } else if (dx <= 0 && dy >= 0) {
                draw(gl, y1, -x1, y2, -x2, 2);
            } else if (dx <= 0 && dy <= 0) {
                draw(gl, -y1, -x1, -y2, -x2, 5);
            }
        }
    }

    public void draw(GL2 gl, double x1, double y1, double x2, double y2, int slope) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double dne = 2 * dy - 2 * dx;
        double de = 2 * dy;
        double dinit = 2 * dy - dx;
        drawPoint(gl, x1, y1, slope);

        double d1 = y1;
        for (double d = x1 + 0.0001; d < x2; d = d + 0.0001) {
            if (dinit > 0) {
                d1 = d1 + 0.0001;
                drawPoint(gl, d, d1, slope);
                dinit = dinit + dne;
            } else {
                drawPoint(gl, d, d1, slope);
                dinit = dinit + de;
            }
        }
        drawPoint(gl, x2, y2, slope);
    }

    public void drawPoint(GL2 gl, double x, double y, int s) {
        if (s == 0) {
            gl.glVertex2d(x, y);
        } else if (s == 1) {
            gl.glVertex2d(y, x);
        } else if (s == 2) {
            gl.glVertex2d(-y, x);
        } else if (s == 3) {
            gl.glVertex2d(-x, y);
        } else if (s == 4) {
            gl.glVertex2d(-x, -y);
        } else if (s == 5) {
            gl.glVertex2d(-y, -x);
        } else if (s == 6) {
            gl.glVertex2d(y, -x);
        } else if (s == 7) {
            gl.glVertex2d(x, -y);
        }

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        drawable.getGL().setSwapInterval(20);

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {

    }
}
