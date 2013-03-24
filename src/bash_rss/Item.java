package bash_rss;

public class Item {
	private String jokeGuid;
	private String jokeLink;	
	private String jokeTittle;
	private String jokeDate;
	private String joke;

	public void setJokeGuid (String jokeGuid){
		this.jokeGuid = jokeGuid;
	}
	public String getJokeGiud (){
		return this.jokeGuid;
	}
	public void setJokeLink (String jokeLink){
		this.jokeLink = jokeLink;
	}
	public String getJokeLink (){
		return this.jokeLink;
	}
	public void setJokeDate (String jokeDate){
		this.jokeDate = jokeDate;
	}
	public String getJokeDate (){
		return this.jokeDate;
	}
	public void setJokeTittle (String jokeTittle){
		this.jokeTittle = jokeTittle;
	}
	public String getJokeTittle (){
		return this.jokeTittle;
	}
	public void setJoke (String joke){
		this.joke = joke;
	}
	public String getJoke (){
		return this.joke;
	}
	
	public String toString(){
		return this.jokeTittle+"\n"+this.jokeDate+"\n"+this.joke+"\n"; 		
	}
}