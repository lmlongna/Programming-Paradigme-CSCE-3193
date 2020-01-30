////////////////////////////////////////////////////////////
//  CSCE 3193 Programming Paradigms
//  Fall 2019
//  Assignment 8
//  Name: Lambert Longnang  
////////////////////////////////////////////////////////////


//function reverseArray (arr){
//  var reversed = [];
//
//  function reverser (arr){
//    if (arr.length !== 0){
//      reversed.push( arr.pop() );
//      reverser( arr );
//    }
//  }
//
//  reverser(arr);
//  return reversed;
//}

function reverseArray(arr)
{
  return arr.length < 2 ? arr :
  [arr.pop()].concat(reverseArray(arr));
}
 
    

//2)******************findMin****************************

//
//    if (a.length < 2) {
//        return a[0];
//    }
//
//    return Math.min(a.shift(), findMin(a));
//}

function findMin(a) {
    return a.length === 1 ? a[0]: findMin(a.slice(2).concat(a[0] < a[1] ? a[0] : a[1]));
}
//3)************stringFromArrays******************

function stringFromArrays(arr1, arr2) {
    
    if (arr1.length==1)
    return (arr1.pop().toString()+arr2.pop().toString());
   
    var a1=arr1.pop();
    var a2=arr2.pop();
    return (stringFromArrays(arr1, arr2)+a1.toString() + a2.toString()); 
    
}

//function stringFromArrays(arr1, arr2) 
//{
//    if (arr2.length == 0)
//        return arr1;
//    else
//    {
//        if(arr2.length> arr1.length)
//            return arr2.splice(0,1)+stringFromArrays(arr1,arr2);
//        else
//            return arr1.splice(0,1)+stringFromArrays(arr1,arr2);
//    }
//}

////////////////////////////////////////////////////////////
//4)*************** applyToArray*************************

function applyToArray(a) {

return function (f) {
       
        var b = [];
        for (item of a) {
            b.push(f(item));
        }
        
        return b;
    }
}

// 5)******************compute Max****************
function computeMaxArr(f1, f2) {
	
    
    function fx(a) {
        if(a.length == 1) {
            return [(f1(a[0]) > f2(a[0])) ? f1(a[0]) 
                    : f2(a[0])];
        }

        return fx([a[0]]).concat(fx(a.slice(1)));
    }

    return fx;
}

// 6)******************Common closure******************

function makeClosure() {
	
    var counter = 0;
    var arr = [];

    var returnFunc = [2];

    function f1(arg1, arg2) {
        if( counter < 3 ) 
            arr.push(arg1 + arg2);
        return arr;
    }

    function f2() {
        counter = counter + 1;
    }

    var f = [f1, f2];
    return f;




}

////////////////////////////////////////////////////////////
//  Auxiliary functions (used for testing)

function mult4(i) {
	return i*4;
}

function add2(j) {
	return j+2;
}

function square(k) {
	return k*k;
}
