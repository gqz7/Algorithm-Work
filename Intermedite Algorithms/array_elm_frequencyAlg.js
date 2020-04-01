const arr = [0,0,0,0,2,3,6,4,2,3,4,5,2,1,2,3,4];

let counts = {}

arr.sort()

for (let i = 0; i < arr.length; i++) {
    
    if (counts[arr[i]]) {
        
        counts[arr[i]]++
    } else {
        counts[arr[i]] = 1;
    }
    
}

console.log(counts);

