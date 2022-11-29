
function compare(a, b){
    if(a[0]<b[0]){
        return -1;

    }
    if(a[0]>b[0]){
        return 1;
    }
    return 0;
}


function sortArray(array){
    array.sort((a,b)=>{
        return a-b;
    })
    var objArray = []
    var neoArry = []
    var count =1;    
    for (var i=0; i<array.length;i++){
        if(array[i]===array[i+1]){
            for (var j=i; j<array.length; j++){
                if(array[j]===array[j+1]){
                    count=count+1;            
                }else{
                    objArray.push([count, arr[j]]);
                    i=j;
                    j=array.length;
                    count=1;
                }            
            }            
        }else{   
            objArray.push([count, arr[i]]);
        }
    }    
    objArray.sort(compare);    
    objArray.map((item)=>{
        for(var h=0; h<item[0]; h++){
            neoArry.push(item[1]);
        }        
    });
    console.log("neoArry>>>",neoArry);
}

var arr = [8,2,4,5,5, 5,3,9,3, 11, 3,3];
console.log(arr);
sortArray(arr);
