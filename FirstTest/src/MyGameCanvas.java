import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;


public class MyGameCanvas extends GameCanvas {

	private int currentPos=1;
	private int oldPos=0;
	
	private int currentRow=1;
	private int currentCol=1;
	int col1;
	int col2;
	int col3;
	int col4;
	int unitBoxwidth ;
	protected MyGameCanvas(boolean suppressKeyEvents) {
		super(suppressKeyEvents);
		drawGame();
		// TODO Auto-generated constructor stub
	}
	protected void hideNotify(){
		System.out.println( "hideNotify" );
	}

	protected void keyPressed( int key ){
		System.out.println( "keyPressed " + key + " "
			+ getGameAction( key ) );
		
		int keypressed=getGameAction( key ) ;
		switch(keypressed)
		{
		case Canvas.UP:
			System.out.println("Up");
			if(currentPos>4)
			{
				oldPos=currentPos;
				currentPos-=4;
			}
			currentRow-=1;
			break;
		case Canvas.DOWN:
			System.out.println("down");
			if(currentPos<12)
			{
				oldPos=currentPos;
				currentPos+=4;
			}
			currentRow+=1;
			break;
		case Canvas.RIGHT:
			System.out.println("right");
			oldPos=currentPos;
			currentPos+=1;
			currentCol+=1;
			if(currentCol>4)
				currentCol=1;
			break;
		case Canvas.LEFT:
			System.out.println("left");
			oldPos=currentPos;
			currentPos-=1;
			currentCol-=1;
			if(currentCol<1)
				currentCol=4;
			break;
		case Canvas.FIRE:
			break;
		}
		
		drawGame();
		setSelectedBox();
	}

	protected void showNotify(){
		System.out.println( "showNotify" );
	}
	
	private void drawGame()
	{
		Graphics g=getGraphics();
		
		g.setColor(255,255,255);
		g.fillRect(0, 0, getWidth(), getHeight());
		int width=getWidth();
		int margin=5;
		unitBoxwidth =width;
		System.out.println("unitBoxwidth1"+unitBoxwidth);
		unitBoxwidth=unitBoxwidth-(margin*2);
		System.out.println("unitBoxwidth2"+unitBoxwidth);
		unitBoxwidth=(unitBoxwidth/4)-margin;
		System.out.println("unitBoxwidth3"+unitBoxwidth);
		g.setColor(0, 255, 0);
		int startingX=margin;
		int count=1;
		
		
		int top=2;
		System.out.println("width"+width);
		for(;count<=16;count++)
		{
			System.out.println("startingX"+count+" "+startingX);
			System.out.println("unitBoxwidth"+unitBoxwidth);
			System.out.println("top"+top);
			g.fillRect(startingX,top,   unitBoxwidth,30);
			if(count==1)
				col1=startingX;
			if(count==2)
				col2=startingX;
			if(count==3)
				col3=startingX;
			if(count==4)
				col4=startingX;
			startingX+=(unitBoxwidth+(margin));
			if((count%4)==0)
			{
				startingX=margin;
				top+=30+margin;
			}
			
			
		}
		
		setSelectedBox();
	}

	private void setSelectedBox()
	{
		int top = 0;
		int left;
		Graphics g=getGraphics();
		if(currentPos<=4)
		{
			top=2;
		}
		else if(currentPos>=5 && currentPos<=8)
		{
			top=37;
		}
		else if(currentPos>=9 && currentPos<=12)
		{	
			top=72;
		}
		else if(currentPos>=13 )
		{	
			top=107;
		}
		System.out.println("currentCol"+currentCol);
		System.out.println("currentPos"+currentPos);
		System.out.println("top"+top);
		g.setColor(0, 0, 255);
		if(currentCol==1)
		{
			g.fillRect(col1,top,   unitBoxwidth,30);
			
		}
		else if(currentCol==2)
		{
			g.fillRect(col2,top,   unitBoxwidth,30);
			
		}
		else if(currentCol==3)
		{
			
			g.fillRect(col3,top,   unitBoxwidth,30);
		}
		else if(currentCol==4)
		{
			
			g.fillRect(col4,top,   unitBoxwidth,30);
		}
	
		flushGraphics();
	}
}
