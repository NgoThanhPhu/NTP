from sklearn import tree

my_tree = tree.DecisionTreeClassifier()
status = [[1, 4, 6, 9, 9],
          [2, 5, 7, 8, 3],
          [2, 4, 7, 3, 3],
          [1, 5, 6, 8, 3],
          [2, 3, 6, 9, 8],
          [3, 4, 7, 9, 9],
          [1, 5, 6, 8, 9],
          ]
label = [0, 1, 0, 1, 0, 0, 1]
result = my_tree.fit(status, label)
kq = result.predict([[3, 4, 7, 3, 8]])
print(" Result of prediction that got heart desease: ",kq)
