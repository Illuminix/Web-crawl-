# Web-crawl-####################################
A probably not functional web crawler for fun.##
################################################
################################################
General format:
ArrayList<String> all_of_the_links = new ArrayList<String>
ArrayList<String> a = new ArrayList<String>
use a link to seed the arraylist with values
loop{
  Get HTML from the page
    take string for url
    return document object

  Get Links from the HTML
    takes document as input
    returns Elements Object
  
  Turn link segments into full links{
    Takes Elements as input
    returns ArrayList<String> object
 if links arent in list of all the links add them to the list
 Replace ArrayList "a"'s values before looping back 
Break when desired number of links is obtained
}
go through links in link list and parse all information that you want from the links.

