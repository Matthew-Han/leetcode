/**
 * 根据规则将箱子分类
 * @param {number} length
 * @param {number} width
 * @param {number} height
 * @param {number} mass
 * @return {string}
 */
let categorizeBox = function (length, width, height, mass) {
    let bulky = length >= 10000 || width >= 10000 || height >= 10000 || length * width * height >= 1000000000;
    let heavy = mass >= 100;
    return (bulky && heavy) ? 'Both' : bulky ? 'Bulky' : heavy ? 'Heavy' : 'Neither';
};