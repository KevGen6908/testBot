#!/bin/bash

# Найти и удалить все директории META-INF
find . -type d -name "META-INF" -exec rm -rf {} +

# Найти и удалить все файлы с расширениями .SF, .RSA, .DSA
find . -type f \( -name "*.SF" -o -name "*.RSA" -o -name "*.DSA" \) -exec rm -f {} +

echo "Все папки META-INF и файлы с расширениями .SF, .RSA, .DSA удалены."
