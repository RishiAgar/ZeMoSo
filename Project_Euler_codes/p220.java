package mine;

public class p220 
{
    public static void main(String args[])
    {
        long[] X = new long[42];
        long[] Y = new long[42];
        long[] completeSteps = new long[42];
	int i = 2, dir = 0;
        long x = 0, y = 1, steps, maxSteps, temp_x, temp_y, pos_x = 0, pos_y = 0;
	maxSteps = (long)Math.pow(10,12);
	steps = 1;
	X[1] = x; 
        Y[1] = y; 
        completeSteps[1] = 1;
	while ( steps < maxSteps)
        {
		temp_x = x; 
                temp_y = y;
		x = temp_x + temp_y;
		y = temp_y - temp_x;
		steps = steps + steps;
		X[i] = x; 
                Y[i] = y; 
                completeSteps[i] = steps; 
                i++;
	}
        x = 1; 
        y = 1; 
        i--;
	while( maxSteps > 0 )
        {
            if( maxSteps > completeSteps[i])
            {
                switch(dir)
                {
                    case 0: 
                        x = X[i+1]; 
                        y = Y[i+1]; 
                        dir = 3;
                        break;
                    case 1: 
                        x = Y[i+1]; 
                        y =-X[i+1];
                        dir = 0;
                        break;
                    case 2: 
                        x =- X[i+1]; 
                        y =- Y[i+1]; 
                        dir = 1;
                        break;
                    case 3: 
                        x =- Y[i+1]; 
                        y = X[i+1];
                        dir = 2;
                        break;
                }
                pos_x += x; 
                pos_y += y;
                maxSteps = completeSteps[i+1] - maxSteps;
            }
            i--;
	}
        System.out.println( pos_x + "," + pos_y);
    }
}
    