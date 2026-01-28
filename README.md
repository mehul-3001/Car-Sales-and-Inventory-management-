function groupArray(data: any[]) {
  const map: Record<string, any[]> = {};

  for (const item of data) {
    const groupKey = `${item.type}_${item.status}`;

    if (!map[groupKey]) {
      map[groupKey] = [];
    }
    map[groupKey].push(item);
  }

  return Object.entries(map).map(([group, items]) => ({
    group,
    items
  }));
}
