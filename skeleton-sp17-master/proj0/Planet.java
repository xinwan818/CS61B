public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	static Double G=6.67*Math.pow(10,-11);

	public Planet(double xP,double yP,double xV,
		          double yV,double m ,String img){
		
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

	public Double calcDistance(Planet p){
		Double s;
		s = Math.sqrt(Math.pow((this.xxPos - p.xxPos),2) 
			+ Math.pow((this.yyPos - p.yyPos),2));

		return s;
	}

	public Double calcForceExertedBy(Planet p){
		Double f;

		f = G*this.mass * p.mass/(Math.pow(this.calcDistance(p),2));

		return f;
	}

	public Double calcForceExertedByX(Planet p){
		Double fx;
		fx = this.calcForceExertedBy(p)*((p.xxPos-xxPos)/this.calcDistance(p));
		return fx;
	}

	public Double calcForceExertedByY(Planet p){
		Double fy;
		fy = this.calcForceExertedBy(p)*((p.yyPos-yyPos)/this.calcDistance(p));
		return fy;
	}

	public Double calcNetForceExertedByX(Planet[] pn){
		Double netFX = 0.0;
		int n,m;
		n = pn.length;
		m = 0 ;
		while(m<n){
			if (pn[m].xxPos == this.xxPos && pn[m].yyPos == this.yyPos){
				m+=1;
				continue;
			}
			netFX += calcForceExertedByX(pn[m]);
			m+=1;
		}
		return netFX;
	}
	public Double calcNetForceExertedByY(Planet[] pn){
		Double netFY = 0.0;
		int n,m;
		n = pn.length;
		m = 0 ;
		while(m<n){
			if (pn[m].xxPos == this.xxPos && pn[m].yyPos == this.yyPos){
				m+=1;
				continue;
			}
			netFY += calcForceExertedByY(pn[m]);
			m+=1;
		}
		return netFY;
	}

	public void update(Double dt,Double fX,Double fY){
		xxVel = xxVel+dt*fX/mass;
		yyVel = yyVel+dt*fY/mass;
		xxPos = xxPos+dt*(xxVel);
		yyPos = yyPos+dt*(yyVel);
	}

}
