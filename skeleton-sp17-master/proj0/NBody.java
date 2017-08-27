public class NBody {
	public static Double readRadius(String args){
		Double n,r;
		In file = new In(args);

		n = file.readDouble();
		r = file.readDouble();

		return r;
	}

	public static Planet[] readPlanets(String args){

		Planet[] planets = new Planet[5];

		In file = new In(args);
		file.readLine();
		file.readLine();

		
		

		for(int i = 0; i<5; i++ )
		{
			
			Double xxPos = file.readDouble();
			Double yyPos = file.readDouble();
			Double xxVel = file.readDouble();
			Double yyVel = file.readDouble();
			Double mass = file.readDouble();
			String imgFileName = file.readString();
			planets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);

		} 

	
		return planets;
	}

	public static void main(String[] args){
		Double T = Double.parseDouble(args[0]);
		Double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Double r = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		Double[] xForce = new Double[6312];
		Double[] yForce = new Double[6312];
		Double xF,yF;
		
		
		Double time = 0.0;
		int n = 0;
		while(time < T){
			
			for(int j = 0; j<5;j++){
				xForce[n]=planets[j].calcNetForceExertedByX(planets);
				yForce[n]=planets[j].calcNetForceExertedByY(planets);
				planets[j].update(dt, xForce[n],yForce[n]);

			}

		 	StdDraw.setScale(r,-r);
			StdDraw.clear();
			StdDraw.picture(0,0,"images/starfield.jpg");
			for (int i = 0; i<5; i++){

			StdDraw.picture(planets[i].xxPos,planets[i].yyPos, planets[i].imgFileName);

			}

			StdDraw.show(10);

			n = n+1;
			time = time +dt;
		}




	}

}
