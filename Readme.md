# B-Tree
## Post Order Traversal in BTree

*** 
### *Description*:

*B-trees are balanced search trees designed to work well on disks or other direct access
secondary storage devices.*

A Project for Advance Data Structures in B.E. Computer Science Course.

```
1. The idea is to create B-Tree perform insertion and post order traversal.

data inputs = {10, 4, 12, 14, 25, 20, 5, 6, 8, 13}
minimuum degree t = 2

insertion 10, 4, 12

                [4 10 12]

insertion 14
                 [10]

            [4]       [12 14]

insertion 25

                 [10]

            [4]       [12 14 25]

insertion 25

                 [10]

            [4]         [14]
                    
                    [12]    [25]

insertion 20

                 [10]

            [4]         [14]
                    
                    [12]    [20 25]


insertion 5, 6

                 [10]

        [4 5 6]         [14]
                    
                    [12]    [20 25]


insertion 8 13 22

                  [10]

        [5]                    [14]

[4]         [6 8]     [12 13 ]    [20 22 25]


```
## Post order Traversal

### *For leaf Node*

Create Binary Search Tree at leaf node and implement post order traversal in it.

### *For non-leaf node* 
```
Travese Through left print Left then print right and the print parent.

ex : - For below given tree


                  [10]

        [5]                     [14]

[4]         [6 8]     [12 13 ]    [20 22 25]



Traversal :  Left Child
[10] -> [5]-> [4]
i.e [4]

create BST [4]

Btree post order : 4

Traversal :  Right Child
[10] -> [5] -> [6 8] 
i.e [6 8]

create BST [6 8]
    [6]
        [8]

post order of BST : 8 6

Btree post order : 4 8 6

Traversal :  Left Child
[10] -> [5]

Btree post order : 4 8 6 5

Traversal :  Left Child
[10] -> [14] -> [12 13 14]

create BST [13 14]
    [12]

       [13]

post order of BST : 13 12

Btree post order : 4 8 6 5 13 12

Traversal :  Right Child
[10] -> [14] -> [20 22 25]

create BST [20 25]
    [20]
        
[22]    [25]

post order of BST : 22 25 20

Btree post order : 4 8 6 5 13 12 22 25 20

Traversal :  Right Child
[10] -> [14] 

Btree post order : 4 8 6 5 13 12 22 25 20 14

Traversal :  Root
[10] 

Btree post order : 4 8 6 5 13 12 22 25 20 10

```
*****************************************
### *Programming Language*:

Java
*****************************************

### *Key functionality*: 
```
1. Insertion
2. Post Order Traversal
3. Level Order Traversal
4. Search Key
5. height
```
### *Output*: 
```
*************************************************************
1.Run demo Tree
2.Create own Tree
0.Terminate
*************************************************************
1
Data :
10 4 12 14 25 20 5 6 8 13 
-------------------------------------------------------------
Btree Height:
3
-------------------------------------------------------------
Level Order Traversal:
 [x]   represents x is leaf node
{[x]}  represents x is non - leaf node
{[ 10 ]} {[ 5 ]} {[ 14 ]} [ 4 ] [ 6 8 ] [ 12 13 ] [ 20 25 ] 
-------------------------------------------------------------
Post Order Traversal:
4 8 6 5 13 12 25 20 14 10 

*************************************************************
```
### *Running the code*:

### *How to run in netbeans*
```

1. Clone or download this repository.

2. Create java Project or open existing.

3. Create package Name "BTRee" in Netbeans.

4. Insert all the files in the pacakge

5. Run main file.

```
****
