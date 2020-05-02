public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV,
                double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Body b) {
        double G = 6.67e-11;
        double radiusSquare = this.calcDistance(b) * this.calcDistance(b);
        return G * this.mass * b.mass / radiusSquare;
    }

    public double calcForceExertedByX(Body b) {
        double F = this.calcForceExertedBy(b);
        double dx = b.xxPos - this.xxPos;
        double radius = this.calcDistance(b);
        return F * dx / radius;
    }

    public double calcForceExertedByY(Body b) {
        double F = this.calcForceExertedBy(b);
        double dy = b.yyPos - this.yyPos;
        double radius = this.calcDistance(b);
        return F * dy / radius;
    }

    public double calcNetForceExertedByX(Body[] bs) {
        double result = 0;
        for (Body b: bs) {
            if (this.equals(b)) {
                continue;
            }
            result += this.calcForceExertedByX(b);
        }
        return result;
    }

    public double calcNetForceExertedByY(Body[] bs) {
        double result = 0;
        for (Body b: bs) {
            if (this.equals(b)) {
                continue;
            }
            result += this.calcForceExertedByY(b);
        }
        return result;
    }

    public void update(double dt, double fX, double fY) {
        double aNetX = fX / this.mass;
        double aNetY = fY / this.mass;
        this.xxVel = this.xxVel + dt * aNetX;
        this.yyVel = this.yyVel + dt * aNetY;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}