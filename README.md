function reduceByCategory(data) {
  return Object.values(
    data.reduce((acc, { category, attachmentName, ...rest }) => {
      if (!acc[category]) {
        acc[category] = {
          category,
          attachmentName: [attachmentName],
          ...rest
        };
      } else {
        acc[category].attachmentName.push(attachmentName);
      }
      return acc;
    }, {})
  );
}
