/*
 * Fence Voltage Problem Description In the year 2500, Raju is building a fence
 * to safeguard his crops from animal intrusion. The fence consists of
 * electrified wires that deliver a shock upon contact. This is done to secure
 * the crops.
 * 
 * Assume the fence in a 2D grid where these straight wires may intersect. Each
 * intersection generates a voltage that is transmitted throughout the entire
 * fence. The voltage generated at each intersection depends on the number of
 * wires crossing at that point multiplied by the absolute minimum number of
 * cells these wires touch from the intersection point to both sides (if the
 * wire extends in both directions through the point).
 * 
 * Consider the below figure.
 * 
 * com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@4d4960c8:image1.png
 * 
 * There are three wires in the fence. All three are intersecting at a point (2,
 * 2) hence some voltage will be developed at the point which is (number of
 * wires intersecting) * (minimum of number of cells all the wires are touching
 * from the centre).
 * 
 * Let us calculate the minimum of number of cells all the wires are touching
 * from centre.
 * 
 * For the wire (2, 0, 2, 4), it is touching 2 cells on one side of the point of
 * intersection and 2 cells on other side.
 * 
 * For the wire (0, 2, 4, 2), it is touching 2 cells on one side of the point of
 * intersection and 2 cells on other side.
 * 
 * For the wire (0, 0, 2, 2), it is touching 2 cells on one side of the point of
 * intersection.
 * 
 * Hence absolute minimum of number of cells all wires are touching from centre
 * min (2, 2, 2, 2, 2) =2
 * 
 * The voltage generated at the point (2, 2) will be 3 (wires)* 2 (absolute
 * minimum # of cells) = 6 units which will be passed throughout the circuit.
 * 
 * The voltage generated at a specific point on the fence will be evenly
 * distributed throughout the entire structure i.e., if more than one
 * intersection is present, the total voltage will be sum of all voltages at
 * intersections. Given the locations of wires on a 2D plane, a list of animal
 * names with their respective voltage resisting thresholds, and the name of an
 * animal that accidentally touched the fence, determine whether that animal can
 * die by touching the fence. Also, find the probability, up to two decimal
 * places, of animals dying by coming in contact with the fence. See Example
 * section for better understanding.
 * 
 * Constraints 1 <= N <= 50
 * 
 * 0 <= x, y <= 100
 * 
 * 1 <= Number of Animals <= 50
 * 
 * Input First line consists of an integer N, denoting the number of wires.
 * 
 * Next N lines will be having 4 space separated integers denoting the
 * coordinates of starting and ending points of the wire segments in the fence
 * placed in 2D plane.
 * 
 * The next line contains a string consisting of key-value pairs, separated by
 * spaces, where each key and value in the pair is separated by a semicolon.
 * This denotes animals and their respective voltage resisting thresholds
 * 
 * Last line consists of a string indicating the animal that accidentally
 * touched the fence.
 * 
 * Output On the first line, print "Yes" if the animal died, else print "No"
 * 
 * On the second line print the probability, up to two decimal places, of Raju
 * securing his crops if all the animals intruded into his farm
 * 
 * Time Limit (secs) 1
 * 
 * Examples Example 1
 * 
 * Input
 * 
 * 7
 * 
 * 4 2 4 6
 * 
 * 6 5 6 7
 * 
 * 1 3 3 5
 * 
 * 3 5 4 4
 * 
 * 3 3 7 7
 * 
 * 2 2 2 5
 * 
 * 4 4 5 3
 * 
 * buffallo:15 dog:10 crow:2 pig:12 donkey:14 cat:7
 * 
 * dog
 * 
 * Output
 * 
 * Yes
 * 
 * 0.50
 * 
 * Explanation
 * 
 * The given fence is represented in the 2D plane below.
 * 
 * com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@4d4960c8:image2.png
 * 
 * The voltage will be generated at 4 points viz., (2, 4), (4, 4), (3, 5), (6,
 * 6)
 * 
 * Voltage generated at (2, 4) => 2 * min (1, 1, 2, 1) = 2
 * 
 * Voltage generated at (4, 4) => 4 * min (1, 1, 2, 1, 3, 2) = 4
 * 
 * Voltage generated at (3, 5) => 2 * min (2, 1) = 2
 * 
 * Voltage generated at (6, 6) => 2 * min (1, 1, 1, 3) = 2
 * 
 * Therefore, the total voltage passing through the fence is 2+4+2+2=10.
 * 
 * Since the animal that touched the fence is a dog, and it can only survive up
 * to a voltage of 10 (exclusive), but the fence carries a voltage of 10, it
 * will certainly lose its life. Therefore, print "Yes".
 * 
 * Since 3 out of 6 animals have voltage resisting capacity lesser than voltage
 * of his fence, the probability of animals dying by accidentally touching the
 * fence is 3/6 i.e., 0.5. Hence the probability of Raju securing his crops if
 * all animals intruded into his fence is 0.5.
 * 
 * Example 2
 * 
 * Input
 * 
 * 5
 * 
 * 1 1 8 8
 * 
 * 3 1 3 4
 * 
 * 5 1 5 8
 * 
 * 1 3 3 3
 * 
 * 7 2 7 9
 * 
 * goat:9 pig:13 cow:15 elephant:25 dog:7 deer:12
 * 
 * cow
 * 
 * Output
 * 
 * No
 * 
 * 0.33
 * 
 * Explanation
 * 
 * The given fence is represented in the 2D plane below.
 * 
 * com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@4d4960c8:image3.png
 * 
 * The voltage will be generated at 3 points viz., (3, 3), (5, 5), (7, 7)
 * 
 * Voltage generated at (3, 3) => 3 * min (1, 2, 2, 2, 5) = 3
 * 
 * Voltage generated at (5, 5) => 2 * min (3, 3, 4, 4) = 6
 * 
 * Voltage generated at (7, 7) => 2 * min (1, 2, 6, 5) = 2
 * 
 * Therefore, the total voltage passing through the fence is 3+6+2 = 11.
 * 
 * Since the animal that touched the fence is a cow, and it can only survive up
 * to a voltage of 14, but the fence carries a voltage of 11, it will not lose
 * its life. Therefore, print "No".
 * 
 * Since 2 out of 6 animals have voltage resisting capacity lesser than voltage
 * of his fence, the probability of animals dying by accidentally touching the
 * fence is 2/6 i.e., 0.33. Hence the probability of Raju securing his crops if
 * all animals intruded into his fence is 0.33.
 */