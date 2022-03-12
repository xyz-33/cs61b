public class NBody{
	public static double readRadius(String file_dir){
		In in = new In(file_dir);
		int planet_number = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String file_dir){
		In in = new In(file_dir);

		int planet_number = in.readInt();
		double radius = in.readDouble();

		Planet[] planetArray;//声明
		planetArray = new Planet[5];//创建		
		int i;
		for(i=0; i<5; i++) {
			double xxpos = in.readDouble();
			double yypos = in.readDouble();
			double xxvel = in.readDouble();
			double yyvel = in.readDouble();
			double planet_mass = in.readDouble();
			String imgName = in.readString();
			planetArray[i] = new Planet(xxpos, yypos, xxvel, yyvel, planet_mass, imgName);
		}
		return planetArray;
	}
    public static void main(String[] args) {
    	//Collecting All Needed Input
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        String background_image = "./images/starfield.jpg";
        //Drawing the Background
        //set the scale so that it matches the radius of the universe. 
        StdDraw.setScale(-radius, radius);
        //draw the image starfield.jpg as the background
        /*
        
        StdDraw.picture(0, 0, background_image);
        //Drawing All of the Planets
        int i;
        for(i=0; i<planets.length; i++){
        	planets[i].draw();
        }
        */
        int i;
        StdDraw.enableDoubleBuffering();
        double time = 0;
        int waitTimeMilliseconds = 10;
        double[] xForces = new double[5];
        double[] yForces = new double[5];
        while(time != T){
        	for(i=0; i<planets.length; i++){
        		xForces[i] = planets[i].calcNetForceExertedByX(planets);
        		yForces[i] = planets[i].calcNetForceExertedByY(planets);
        	}
        	for(i=0; i<planets.length; i++){
        		planets[i].update(dt, xForces[i], yForces[i]);
        	}
        	StdDraw.picture(0, 0, background_image);
        	for(i=0; i<planets.length; i++){
        		planets[i].draw();
        	}
        	StdDraw.show();
        	StdDraw.pause(waitTimeMilliseconds);  
        	time = time + dt;      	        	
        }
    }			
	StdOut.printf("%d\n", planets.length);
	StdOut.printf("%.2e\n", radius);
	for (int i = 0; i < planets.length; i++) {
    	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  	planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                 	planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
	}	
}