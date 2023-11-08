class product:
    def __init__(self,profit,weight): #constructor
        self.profit=profit
        self.weight=weight

def calc(arr,w):
    
    arr.sort(key=lambda x:x.profit/x.weight,reverse=True)#sorting in decreasing order
    final=0.0
    for item in arr: #calculating weight and profit
        if(item.weight<=w):
            w=round(w-item.weight,3)
            final=final+item.profit
            print("Weight include : ",item.weight,end='\t')
            print("Profit included : ",item.profit,end='\t')
        else:
            new_weight=round(w/item.weight,3)
            amt=new_weight*item.profit
            final=final+amt
            print("Weight include : ",new_weight,end='\t')
            print("Profit included : ",amt,end='\t')

            #print(new_weight)
        print("Amount : ",final)    
    print("Profit: ",final,"\n")

def main():  #Driver code

    print("Test case I : ")
    arr1=[product(60,10),product(100,20),product(120,30)] #Test  cases
    w1=50
    calc(arr1,w1)
    print("Test case II : ")
    arr2=[product(100,40),product(60,5),product(120,10)]
    w2=30
    calc(arr2,w2)
    print("Test case III : ")
    arr3=[product(90,20),product(50,10),product(120,30)]
    w3=35
    calc(arr3,w3)

   #user input 
    arr4=[]
    pf=[]
    wt=[]
    w4=int(input("Enter capacity : "))
    for j in range(0,3,1):
        pf.append(int(input("Enter profit : ")))
        wt.append(float(input("Enter weight :")))
    for i in range(0,3):
        arr4.append(product(pf[i],wt[i]))
    #calculate
    calc(arr4,w4)

main()

"""   OUTPUT
Test case I : 
Weight include :  10    Profit included :  60   Amount :  60.0
Weight include :  20    Profit included :  100  Amount :  160.0
Weight include :  0.667 Profit included :  80.04        Amount :  240.04000000000002
Profit:  240.04000000000002 

Test case II : 
Weight include :  5     Profit included :  60   Amount :  60.0
Weight include :  10    Profit included :  120  Amount :  180.0
Weight include :  0.375 Profit included :  37.5 Amount :  217.5
Profit:  217.5 

Test case III : 
Weight include :  10    Profit included :  50   Amount :  50.0
Weight include :  20    Profit included :  90   Amount :  140.0
Weight include :  0.167 Profit included :  20.040000000000003   Amount :  160.04
Profit:  160.04
"""
