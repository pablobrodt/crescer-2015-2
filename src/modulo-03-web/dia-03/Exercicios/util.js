function isString( string ){
	return typeof string === 'string';
}

function isNumber( number ){
	return typeof number === 'number';
}

function isItem( item ){
	return item instanceof Item;
}