function writeLogg(new Array[messages], lvl, sep){
    console.log('messageswriteLogg', messages);   
      let arrayMsg="";
      if(messages.level>lvl){
        console.log(messages.text+sep);
        arrayMsg+=(messages.text + sep);
      }
      return(arrayMsg); 
}

function joinedLogger(level, sep) {
  // write your code here
  console.log('print', level, sep);
  return messages => console.log(messages);
}

var messages=[ { level: 40, text: 'foo' },{ level: 90, text: 'bar' },{ level: 20, text: 'baz' }, { level: 21, text: 'bax' } ];