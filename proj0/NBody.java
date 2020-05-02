public class NBody {

    public static double readRadius(String fileName) {
        In fileHolder = new In(fileName);
        int numberPlanet = fileHolder.readInt();
        double radiusUniverse = fileHolder.readDouble();
        return radiusUniverse;
    }

    public static Body[] readBodies(String fileName) {
        In fileHolder = new In(fileName);
        int N = fileHolder.readInt();
        double R = fileHolder.readDouble();
        Body[] result = new Body[N];
        for (int i = 0; i < N; i++) {
            double xxPos = fileHolder.readDouble();
            double yyPos = fileHolder.readDouble();
            double xxVel = fileHolder.readDouble();
            double yyVel = fileHolder.readDouble();
            double mass = fileHolder.readDouble();
            String file = fileHolder.readString();
            Body body = new Body(xxPos, yyPos, xxVel, yyVel, mass, file);
            result[i] = body;
        }
        return result;
    }

    public static void main (String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        Body[] bodies = readBodies(fileName);
        double universeRadius = readRadius(fileName);

        // draw planets
        StdDraw.setScale(-universeRadius, universeRadius);
        StdDraw.picture(0,0 , "images/starfield.jpg");
        for (Body b: bodies) {
            b.draw();
        }

        // use
        StdDraw.enableDoubleBuffering();
        double time = 0;
        while (time < T) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];

            for (int i = 0; i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }


            for (int j = 0; j < bodies.length; j++) {
                bodies[j].update(dt, xForces[j], yForces[j]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Body b: bodies) {
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        //Print out final state of the universe
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", universeRadius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }

    }
}