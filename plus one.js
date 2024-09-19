var plusOne = function (digits) {
  let arr = digits.join("");
  arr = BigInt(arr);
  ++arr;
  arr = String(arr);
  let temp = [];
  for(let i=0; i<arr.length; i++){
    temp[i] = arr[i];
  }

  digits = [...temp]

  return digits;
};


console.log(plusOne([6, 1, 4, 5, 3, 9, 0, 1, 9, 5, 1, 8, 6, 7, 0, 5, 5, 4, 3]));