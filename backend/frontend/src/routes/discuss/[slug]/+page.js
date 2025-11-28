/** @type {import('./$types').PageLoad} */
export async function load({ fetch, params }) {
    console.log(params.slug);
	const res = await fetch(`https://3.27.115.22.nip.io:8443/discuss/board?boardId=${params.slug}`);
    const items = await res.json();
    console.log(params.slug);

    return { items, boardId: params.slug };
}