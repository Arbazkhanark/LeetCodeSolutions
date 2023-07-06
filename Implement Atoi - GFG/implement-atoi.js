//{ Driver Code Starts
//Initial Template for javascript

"use strict";

process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let currentLine = 0;

process.stdin.on("data", (inputStdin) => {
  inputString += inputStdin;
});

process.stdin.on("end", (_) => {
  inputString = inputString
    .trim()
    .split("\n")
    .map((string) => {
      return string.trim();
    });

  main();
});

function readLine() {
  return inputString[currentLine++];
}

/* Function to print an array */
function printArray(arr, size) {
  let i;
  let s = "";
  for (i = 0; i < size; i++) {
    if(arr[i] == -0)
      arr[i] = 0;
    s += arr[i] + " ";
  }
  console.log(s);
}

function main() {
  let t = parseInt(readLine());
  let i = 0;
  for (; i < t; i++) {
    let s = readLine();   
    let obj = new Solution();
    let res = obj.atoi(s);
    console.log(res);
  }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {string} s
 * @return {number}
 */

class Solution {
    atoi(str){
        let isTrue=false;
        let count=0;
        for(let i=0;i<str.length;i++){
          if(str.charCodeAt(i)>=48 && str.charCodeAt(i)<=57 || str.charCodeAt(i)===45){
              // done
              if(str.charCodeAt(i+1)==45){
                  return -1;
              }
          }else{
            return -1;
          }
        }
        
        if(str.includes("--")){
            return -1
        }
        return str
    
    }
}