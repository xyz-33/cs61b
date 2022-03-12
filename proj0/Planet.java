/** Class that 
 *  @author YOUR NAME HERE
 */
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        double dx = p.xxPos - xxPos;
        double dy = p.yyPos - yyPos;
        double dist = Math.sqrt(dx*dx + dy*dy);
        return dist;
    }
    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        double force = G*mass*p.mass/(r*r);
        return force;
    }
    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        double fx = calcForceExertedBy(p)*dx/r;
        return fx;
    }
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - yyPos;
        double r = calcDistance(p);
        double fy = calcForceExertedBy(p)*dy/r;
        return fy;
    } 
    public double calcNetForceExertedByX(Planet[] allplanets){
    	int i;
    	double netFx = 0;
    	for(i=0;i<allplanets.length;i++){
    		if(this.equals(allplanets[i])){
    			continue;
    		}
    		netFx = netFx + calcForceExertedByX(allplanets[i]);
    	}
    	return netFx;
    } 
    public double calcNetForceExertedByY(Planet[] allplanets){
    	int i;
    	double netFy = 0;
    	for(i=0;i<allplanets.length;i++){
    		if(this.equals(allplanets[i])){
    			continue;
    		}
    		netFy = netFy + calcForceExertedByY(allplanets[i]);
    	}
    	return netFy;
    }
    public void update(double dt, double fx, double fy){
        double ax;
        ax = fx / mass;
        double ay;
        ay = fy / mass;
        xxVel = xxVel + dt * ax;
        yyVel = yyVel + dt * ay;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }
    public void draw(){
        String image_dir = "./images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, image_dir);
    }
}

