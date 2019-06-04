import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from sklearn.neighbors import KNeighborsClassifier
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
# tran_test_split with 75% train and 25% test
iris_datasets = load_iris()
X_train, X_test, y_train, y_test = train_test_split(iris_datasets['data'], iris_datasets['target'], random_state=0)
iris_dataframe = pd.DataFrame(X_train, columns=iris_datasets.feature_names)
pd.plotting.scatter_matrix(iris_dataframe, c=y_train, figsize=(15, 15), marker='o', hist_kwds={'bins': 20}, s=60, alpha=.8,)
plt.show()
knn = KNeighborsClassifier(n_neighbors=1)
knn.fit(X_train, y_train)
# scikit-learn expect 2D for data so np.array([[]])
X_new = np.array([[5, 2.9, 1, 0.2]])
pre = knn.predict(X_new)
print("Prediction: ", pre)
print("Type of iris: {}".format(iris_datasets["target_names"][pre]))
print("The accurate percent of predict: {}".format(knn.score(X_test, y_test)*100))