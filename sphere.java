
import java.awt.event.*;
import javax.swing.*;
import com.jogamp.opengl.util.*;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;

public class sphere extends JFrame implements GLEventListener, KeyListener {

    private static GLCanvas canvas;
    private GLCapabilities caps;
    public static Animator animator;
    int x = 0, y = 0;

    public sphere() {
        super("sphere");
        caps = new GLCapabilities(null);
        canvas = new GLCanvas(caps);
        canvas.addGLEventListener(this);
        canvas.addKeyListener(this);
        getContentPane().add(canvas);
    }

    public void run() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        canvas.requestFocusInWindow();
        animator = new Animator(canvas);
        animator.start();

    }

    public static void main(String[] args) {
        new sphere().run();

    }

    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        float ambient[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float diffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float position[] = {0.0f, 3.0f, 2.0f, 0.0f};
        float lmodel_ambient[] = {0.4f, 0.4f, 0.4f, 1.0f};
        float local_view[] = {0.0f};

        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LESS);

        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambient, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, position, 0);
        gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT, lmodel_ambient, 0);
        gl.glLightModelfv(GL2.GL_LIGHT_MODEL_LOCAL_VIEWER, local_view, 0);

        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);

        //  gl.glClearColor(.5f, .5f, .5f, 0.0f);
    }

    public void gltDrawSphere(GL2 gl, float fRadius, int iSlices, int iStacks) {
        float drho = (float) (3.141592653589) / (float) iStacks;
        float dtheta = 2.0f * (float) (3.141592653589) / (float) iSlices;
        float ds = 1.0f / (float) iSlices;
        float dt = 1.0f / (float) iStacks;
        float t = 1.0f;
        float s = 0.0f;
        int i, j;     // Looping variables  

        for (i = 0; i < iStacks; i++) {
            float rho = (float) i * drho;
            float srho = (float) (Math.sin(rho));
            float crho = (float) (Math.cos(rho));
            float srhodrho = (float) (Math.sin(rho + drho));
            float crhodrho = (float) (Math.cos(rho + drho));

            gl.glBegin(GL.GL_TRIANGLE_STRIP);
            s = 0.0f;
            for (j = 0; j <= iSlices; j++) {
                float theta = (j == iSlices) ? 0.0f : j * dtheta;
                float stheta = (float) (-Math.sin(theta));
                float ctheta = (float) (Math.cos(theta));

                float x = stheta * srho;
                float y = ctheta * srho;
                float z = crho;

                gl.glTexCoord2f(s, t);
                gl.glNormal3f(x, y, z);
                gl.glVertex3f(x * fRadius, y * fRadius, z * fRadius);

                x = stheta * srhodrho;
                y = ctheta * srhodrho;
                z = crhodrho;
                gl.glTexCoord2f(s, t - dt);
                s += ds;
                gl.glNormal3f(x, y, z);
                gl.glVertex3f(x * fRadius, y * fRadius, z * fRadius);
            }
            gl.glEnd();

            t -= dt;
        }
    }

    void drawSphere(GL2 gl, double r, int lats, int longs) {
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -8.0f);
        int i, j;
        for (i = 0; i <= lats; i++) {
            double lat0 = 3.14f * (-0.5 + (double) (i - 1) / lats);
            double z0 = Math.sin(lat0);
            double zr0 = Math.cos(lat0);

            double lat1 = 3.14 * (-0.5 + (double) i / lats);
            double z1 = Math.sin(lat1);
            double zr1 = Math.cos(lat1);

            gl.glBegin(gl.GL_QUAD_STRIP);
            for (j = 0; j <= longs; j++) {
                double lng = 2 * 3.14 * (double) (j - 1) / longs;
                double x = Math.cos(lng);
                double y = Math.sin(lng);

                gl.glNormal3d(x * zr0, y * zr0, z0);
                gl.glVertex3d(x * zr0, y * zr0, z0);
                gl.glNormal3d(x * zr1, y * zr1, z1);
                gl.glVertex3d(x * zr1, y * zr1, z1);
            }
            gl.glEnd();
        }
    }

    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();
        float no_mat[] = {0.0f, 0.0f, 0.0f, 1.0f};
        float mat_ambient[] = {0.7f, 0.7f, 0.7f, 1.0f};
        float mat_ambient_color[] = {0.8f, 0.8f, 0.2f, 1.0f};
        float mat_diffuse[] = {0.1f, 0.5f, 0.8f, 1.0f};
        float mat_specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float no_shininess[] = {0.0f};
        float low_shininess[] = {5.0f};
        float high_shininess[] = {100.0f};
        float mat_emission[] = {0.3f, 0.2f, 0.2f, 0.0f};
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // gl.glPushMatrix();
        //   gl.glTranslatef(-1.25f, 3.0f, 0.0f);
        gl.glTranslated(x, y, 0.0f);
        x += .1;
        y += .1;
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SHININESS, low_shininess, 0);
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_EMISSION, no_mat, 0);
        glut.glutSolidSphere(2.0f, 500, 500);
// gltDrawSphere(gl, 2.0f, 500, 500);        
//gl.glPopMatrix();
        // gl.glFlush();
        //gl.glWindowPos2i(500, 500);
        //glut.glutBitmapString(7, "APPLICAZIONE JOGL");
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        if (w <= (h * 2)) //
        {
            gl.glOrtho(-6.0, 6.0, -3.0 * ((float) h * 2) / (float) w, //
                    3.0 * ((float) h * 2) / (float) w, -10.0, 10.0);
        } else {
            gl.glOrtho(-6.0 * (float) w / ((float) h * 2), //
                    6.0 * (float) w / ((float) h * 2), -3.0, 3.0, -10.0, 10.0);
        }
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
            boolean deviceChanged) {
    }

    public void keyTyped(KeyEvent arg0) {
    }

    public void keyPressed(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent arg0) {
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }
}
