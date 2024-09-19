/*
 * At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). 
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
 * Note that you do not have any change in hand at first.
 * Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.
 */

var lemonadeChange = function (bills) {
    let cash = [];
    let ans;
    for (let i of bills) {
        cash.push(i);
        let change = i - 5;
        if (change == 5) {
            if (cash.includes(change)) {
                ans = true;
                cash.splice(cash.indexOf(change), 1);
            }
            else {
                return false;
            }
        }
        else if (change == 15) {
            if (cash.includes(5)) {
                let c1 = 10;
                let c2 = 5;
                if (cash.includes(c1)) {
                    cash.splice(cash.indexOf(c1), 1);
                    cash.splice(cash.indexOf(c2), 1);
                    ans = true;
                } else {
                    try {
                        cash.splice(cash.indexOf(c2), 1);
                        if (cash.includes(c2)) {
                            cash.splice(cash.indexOf(c2), 1);
                            if (cash.includes(c2)) { 
                                cash.splice(cash.indexOf(c2), 1);
                                ans = true;
                            } else {
                                throw new Error();
                            }
                        } else {
                            throw new Error();
                        }
                    } catch (e) {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
        }
        else {
            ans = true;
        }
    }

    return ans;
};

console.log(lemonadeChange([5, 5, 5, 10, 5, 5, 10, 20, 20, 20]));