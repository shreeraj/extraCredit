var directorCount = 1;
var artistCount = 1;
function more_director(){
	var html = '<tr><td><label>Name</label></td><td><input id="director'+directorCount+'.name" type="text" value="" name="director['+directorCount+'].name"></td>';
	$("#moreDirector").before(html);
	directorCount++;
}

function more_artist(){
	var html = '<tr><td><label>Name</label><td><input id=artist'+artistCount+'.name name=artist['+artistCount+'].name><tr><td><label>Date Of Birth</label><td><input id=artist'+artistCount+'.DOB name=artist['+artistCount+'].DOB><tr><td><label>Birth Place</label><td><input id=artist'+artistCount+'.POB name=artist['+artistCount+'].POB><tr><td><label>About</label><td><input id=artist'+artistCount+'.biography name=artist['+artistCount+'].biography>';
	$("#moreArtist").before(html);
	artistCount++;
}