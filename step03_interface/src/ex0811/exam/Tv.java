package ex0811.exam;

public class Tv extends Elec implements ElecFunction {
    private int channel;
    
    
	public Tv() {}
     public Tv(int channel) {
    	 this.channel=channel;
     }
	public Tv(String code, int cost, int channel) {
		super(code, cost);
		this.channel=channel;
	}

	@Override
	public void start() {
		//A01제품 TV를 12을 본다 or A04의 Audio를 200으로 듣는다.
		System.out.println(getCode()+"제품 " + getClass().getSimpleName()+"를 "+ channel+"로 본다.");

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tv [");
		
		builder.append( super.toString() );
		
		builder.append(", channel=");
		builder.append(channel);
		
		builder.append("]");
		return builder.toString();
	}

}
