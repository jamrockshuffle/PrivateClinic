import os
import sys

import pandas as pd
from keras_preprocessing.image import ImageDataGenerator
import keras.src.saving
import keras


def file_to_csv(file, csv_name):
    df = pd.DataFrame(columns=['Filename', 'Label'])
    df['Filename'] = [file]
    df['Label'] = ['testlabel']
    df.to_csv(csv_name, columns=["Filename", "Label"], encoding='UTF-8')


def main():
    train_image = sys.argv[1]

    csv_name = 'src/main/java/com/kj/clinic/medicalImageClassifier/classifier.csv'
    file_to_csv(train_image, csv_name)

    loaded_model = keras.src.saving.load_model(
        'src/main/java/com/kj/clinic/medicalImageClassifier/classifier.keras')

    test_datagen = ImageDataGenerator(rescale=1. / 255)

    test_dataframe = pd.read_csv('src/main/java/com/kj/clinic/medicalImageClassifier/test.csv')
    test_dataset = test_datagen.flow_from_dataframe(
        dataframe=test_dataframe,
        x_col='Filename',
        y_col='Label',
        batch_size=32,
        seed=42,
        shuffle=False,
        class_mode='categorical',
        target_size=(150, 150)
    )

    single_image_dataframe = pd.read_csv(csv_name)
    single_image_dataset = test_datagen.flow_from_dataframe(
        dataframe=single_image_dataframe,
        x_col='Filename',
        y_col='Label',
        batch_size=32,
        seed=42,
        shuffle=False,
        class_mode='categorical',
        target_size=(150, 150),
    )

    prediction = ((loaded_model
                   .predict(single_image_dataset,
                            verbose=0,
                            steps=test_dataset.samples // test_dataset.batch_size) > 0.5)
                  .astype("int32"))

    result_list = []
    for y in prediction:
        for x in y:
            result_list.append(x)

    train_dict = test_dataset.class_indices
    inv_train_dict = {v: k for k, v in train_dict.items()}

    print(inv_train_dict[result_list.index(1)])

    os.remove(csv_name)


if __name__ == "__main__":
    main()
