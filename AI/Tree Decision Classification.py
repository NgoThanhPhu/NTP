from sklearn import tree
import matplotlib.pyplot as plt
import matplotlib
matplotlib.rc('font', family='Arial')
matplotlib.style.use('ggplot')
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
kq = result.predict([[1, 5, 3, 8, 8]])
print("Prediction: ", kq)
plt.plot(status, label, "rx")
plt.title("Relative between status and desease")
plt.show()
